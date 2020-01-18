package com.jk.controller;

import com.jk.model.MinSuModel;
import com.jk.model.MsImgModel;
import com.jk.model.UserModel;
import com.jk.service.UserService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @GetMapping("totest")
    public String test(){
        return "MinShuYeMian/test";
    }

    @PostMapping("test")
    public void test2(String userName){
        userService.test2(userName);
    }


    /**
     * @return   去 主页面
     */
    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }


    /**
     * 验证登录
     * 存入session
     * @param userModel 用户传递的参数
     * @param session   对象
     * @return
     */
    @RequestMapping("queryUser")
    @ResponseBody
    public Map queryUser(UserModel userModel, HttpSession session) {
        HashMap<String, Object> result = new HashMap<>();

        //判断账号是否为空
        UserModel userinfo=userService.findUser(userModel.getUserPhone());

        if (userinfo==null) {
            result.put("code", 2);
            result.put("msg", "账号或密码错误");
            return result;
        }
        //验证密码
        String userpass = userinfo.getUserPasw();
        //加密
        //String userpass2 = Md5Util.getMd532(userModel.getPassword()) ;

        if (!userpass.equals(userModel.getUserPasw())) {
            result.put("code", 3);
            result.put("msg", "账号或密码错误");
            return result;
        }
        //存入session
        session.setAttribute("user",userinfo);

        result.put("code", 0);
        result.put("msg", "验证成功");
        result.put("phone",userinfo.getUserPhone());
        return result;
    }

    /**
     * 注册
     * @param  userModel
     * @return
     */
    @PostMapping("zhuche")
    @ResponseBody
    public String zhucheUser(UserModel userModel){
        return userService.zhucheUser(userModel);
    }

    /**
     * @return 短信验证码
     */
    @GetMapping("yzmcoud")
    @ResponseBody
    public String yzmcoud(String userPhone){
        return userService.yzmcoud(userPhone);
    }


    /**
     * 查询民宿
     */
    @GetMapping("queryMinsu")
    @ResponseBody
    public List<MinSuModel> queryMinsu(){
        //Iterable<MinSuModel>  list=userService.queryMinsu();
       // return list;
        return userService.queryMinsu();
    }


    /**
     * @return   去 查看详情页面
     * 存入session
     */
    @RequestMapping("toqueryMsImg")
    public String queryMinsuOne(String minsuid,HttpSession session){
        MinSuModel minsu=userService.queryMinsuOne(minsuid);
        session.setAttribute("minsu",minsu);
        return "MinShuYeMian/xiangqing";
    }

    /**
     * 查询房间图片
     */
    @GetMapping("queryMsImg")
    @ResponseBody
    public List<MsImgModel> queryMsImg(String minsuid){
        return userService.queryMsImg(minsuid);
    }

    /**
     * 查询房间评价
     */
//    @GetMapping("queryMsImg")
//    @ResponseBody
//    public List<MsImgModel> queryMsImg(String minsuid){
//        return userService.queryMsImg(minsuid);
//    }

    /**
     * 设置高亮
     * @param page
     * @param rows
     * @return
     * /**
     * 使用分词查询
     *
     * @param index          索引名称
     * @param type           类型名称,可传入多个type逗号分隔
      * @param query          查询条件
      * @param size           文档大小限制
      * @param fields         需要显示的字段，逗号分隔（缺省为全部字段）
      *@param sortField      排序字段
      * @param highlightField 高亮字段
      * @return
     */
    @GetMapping("findMinSu")
    public  List<MinSuModel>  find(Integer page,Integer rows,MinSuModel ms){

       // MinSuModel  ms  = new MinSuModel();
        //car.setCarName("兰博");
        if (page==null)
            page = 1;
        if (rows==null)
            rows = 10;

        List<MinSuModel>  list =  new ArrayList<>();
        //1、创建QueryBuilder对象(BoolQueryBuilder是Builder的实现类)
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        //2、创建所要搜索到额条件（查询所有数据）
        // MatchAllQueryBuilder matchAllQueryBuilder=QueryBuilders.matchAllQuery();
        if (ms!=null)
            if (ms.getMsname()!=null && !"".equals(ms.getMsname()))
                //3、把搜索的条件放入到BoolQueryBuilder中
                boolQueryBuilder.must(QueryBuilders.matchQuery("msaname",ms.getMsname()));

        //
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        //设置高亮字段
        highlightBuilder.field("msname");
        //设置前缀
        highlightBuilder.preTags("<span style='color:red'>");
        //设置后缀
        highlightBuilder.postTags("</span>");
        // 创建 Es  客户端
        Client client = elasticsearchTemplate.getClient();
        //设置索引
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("msid")
                .addSort("msprice", SortOrder.DESC)//倒叙
                .setTypes("md_minsu")//类型表名
                .highlighter(highlightBuilder)//设置高亮策略
                .setQuery(boolQueryBuilder)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)//设置查询方式
                .setExplain(true)//是否根据相关度进行排序
                .setFrom((page - 1) * rows)//起始条数
                .setSize(rows);//每页条数
        SearchResponse searchResponse = searchRequestBuilder.get();//获取响应体
        SearchHits hits = searchResponse.getHits();//获取响应体中的数据
        long total =  hits.totalHits;
        Iterator<SearchHit> iterator = hits.iterator();

        while (iterator.hasNext()){

            SearchHit next = iterator.next();

            Map<String, Object> sourceAsMap = next.getSourceAsMap();
            //获取高亮
            Map<String, HighlightField> highlightFields = next.getHighlightFields();

            MinSuModel c = new MinSuModel();

            c.setMsid((Integer) sourceAsMap.get("msid"));

            c.setMsprice((Integer) sourceAsMap.get("msprice"));

            if (highlightFields.get("msname")!=null)
                c.setMsname(highlightFields.get("msname").fragments()[0].toString());
            else
                c.setMsname(sourceAsMap.get("msname").toString());
            list.add(c);
        }
        return  list;
    }

}
