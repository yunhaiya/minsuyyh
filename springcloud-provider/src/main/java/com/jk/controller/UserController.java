package com.jk.controller;

import com.jk.mapper.MsImgModelMapper;
import com.jk.model.MinSuModel;
import com.jk.model.MsImgModel;
import com.jk.model.UserModel;
import com.jk.service.MinSuService;
import com.jk.service.UserServer;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController implements UserServer {


    @GetMapping("test")
    @Override
    public void test(String userName) {

        System.out.println("接收成功get"+userName);
    }

    @PostMapping("test")
    @Override
    public void test2(String userName) {

        System.out.println("接收成功post"+userName);
    }



    @Autowired
    private UserService userService;
    @Autowired
    private MinSuService mInSuService;

    /** =================================================================
     * 注册帐号
     * @param userModel
     * @return
     */
    @PostMapping("zhuche")
    @Override
    public String zhucheUser( UserModel userModel) {

        return userService.zhucheUser(userModel);
    }

    /**
     * @return发送验证码
     */
    @GetMapping("yanzhengma")
    @Override
    public String yzmcoud(String userPhone) {
        return userService.yzmcoud(userPhone);
    }


    /**
     * 查询民宿
     * @return
     */
    @GetMapping("queryMinsu")
    @Override
    public List<MinSuModel> queryMinsu() {
        return mInSuService.queryMinsu();
    }


    /**
     * 验证登录
     * @param userPhone
     * @return
     */
    @GetMapping("queryUser")
    @Override
    public UserModel findUser(String userPhone) {
        return userService.queryUser(userPhone);
    }

    /**
     * 查询单条房间数据
     * @param minsuid
     * @return
     */
    @GetMapping("toqueryMsImg")
    @Override
    public MinSuModel queryMinsuOne(String minsuid) {
        return mInSuService.queryMinsuOne(minsuid);
    }


    /**
     * 查询房间图片
     * @param minsuid
     * @return
     */
    @GetMapping("queryMsImg")
    @Override
    public List<MsImgModel> queryMsImg(String minsuid) {
        return mInSuService.queryMsImg(minsuid);
    }


}
