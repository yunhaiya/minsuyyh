package com.jk.service;

import com.jk.model.Menus;

import java.util.List;

/**
 * @author 杨云海
 * @create 2020-01-16-10:43
 * @description 功能描述
 **/
public interface MinSuService {
    List<Menus> queryMenuTreeByPid(int i);
}
