package com.jk.controller;

import com.jk.model.Menus;
import com.jk.service.MinSuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 杨云海
 * @create 2020-01-16-10:22
 * @description 功能描述
 **/
@Controller
@RequestMapping("menus")
public class MinsuController {
    @Autowired
    private MinSuService minSuService;


    @RequestMapping("queryMenusTree")
    @ResponseBody
    public List<Menus> queryMenuTree(){
        return minSuService.queryMenuTreeByPid(-1);
    }

    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }

}
