package com.jk.service;

import com.jk.dao.MenusDao;
import com.jk.model.Menus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨云海
 * @create 2020-01-16-10:43
 * @description 功能描述
 **/
@Service
public class MinSuServiceImpl implements  MinSuService{

    @Autowired
    private com.jk.dao.MenusDao MenusDao;

    public List<Menus> queryMenuTreeByPid(int pid) {
        List<Menus> list1 = MenusDao.queryMenuTreeByPid(pid);
        if(list1 != null && list1.size()>0){
            for (int i = 0; i < list1.size(); i++) {
                List<Menus> list2 =	queryMenuTreeByPid(list1.get(i).getId());
                list1.get(i).setNodes(list2);
            }
        }
        return list1;
    }
}
