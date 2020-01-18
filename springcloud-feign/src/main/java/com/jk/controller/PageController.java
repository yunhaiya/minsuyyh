package com.jk.controller;

import com.jk.model.MinSuModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("login")
public class PageController {


    /**
     * @return   去 登陆页面
     */
    @RequestMapping("tologin")
    public String login(){
        return "Userlogin/index";
    }

    /**
     * @return   去 注册 页面
     */
    @RequestMapping("zhuche")
    public String zhuche(){

        return "Userlogin/zhuche";
    }


    /**
     * @return   去 百度地图 页面
     */
    @RequestMapping("toditu")
    public String toditu(){
        return "MinShuYeMian/ditu";
    }








}
