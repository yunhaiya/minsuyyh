package com.jk.service;

import com.jk.model.MinSuModel;
import com.jk.model.MsImgModel;

import java.util.List;

/**
 * @author 杨云海
 * @create 2020-01-08-10:13
 * @description 功能描述
 **/
public interface MinSuService {
    List<MinSuModel> queryMinsu();

    MinSuModel queryMinsuOne(String minsuid);

    List<MsImgModel> queryMsImg(String minsuid);
}
