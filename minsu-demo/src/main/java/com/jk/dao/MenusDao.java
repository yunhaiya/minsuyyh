/** 
 * <pre>项目名称:maven-wuliu 
 * 文件名称:MenusDao.java 
 * 包名:com.ysq.dao.menus 
 * 创建日期:2019年10月22日下午7:53:01 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.dao;

import java.util.List;

import com.jk.model.Menus;

public interface MenusDao {

	List<Menus> queryMenuTreeByPid(int pid);

}
