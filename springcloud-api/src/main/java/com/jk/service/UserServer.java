package com.jk.service;

import com.jk.model.MinSuModel;
import com.jk.model.MsImgModel;
import com.jk.model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserServer {

    @GetMapping("user/test")
    void test(@RequestParam("userName") String userName);

    @PostMapping("user/test")
    void test2(@RequestParam("userName") String userName);
    //注册
    @PostMapping("user/zhuche")
    String zhucheUser(@RequestBody UserModel userModel);
    //获取验证码
    @GetMapping("user/yanzhengma")
    String yzmcoud(@RequestParam("userPhone") String userPhone);

    //查询民宿
    @GetMapping("user/queryMinsu")
    List<MinSuModel> queryMinsu();

    //登录
    @GetMapping("user/queryUser")
    UserModel findUser(@RequestParam("userPhone")String userPhone);

    //查询单挑房间数据
    @GetMapping("user/toqueryMsImg")
    MinSuModel queryMinsuOne(@RequestParam("minsuid")String minsuid);
    //查询房间图片
    @GetMapping("user/queryMsImg")
    List<MsImgModel> queryMsImg(@RequestParam("minsuid")String minsuid);
}
