package com.jk.mapper;

import com.jk.model.UserModel;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    // 注册账号
    void zhucheUser(UserModel userModel);

    UserModel queryUserName(@Param("userPhone") String userPhone);
    //登录
    UserModel queryUser(@Param("userPhone")String userPhone);
}
