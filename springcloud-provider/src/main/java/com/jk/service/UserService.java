package com.jk.service;

import com.jk.model.MinSuModel;
import com.jk.model.UserModel;

public interface UserService {

    String zhucheUser(UserModel userModel);

    String yzmcoud(String userPhone);


    UserModel queryUser(String userPhone);

}
