package com.jk.service;

import com.jk.mapper.MinSuModelMapper;
import com.jk.mapper.MsImgModelMapper;
import com.jk.model.MinSuModel;
import com.jk.model.MsImgModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杨云海
 * @create 2020-01-08-10:13
 * @description 功能描述
 **/
@Service
public class MinSuServiceImpl implements  MinSuService{
    @Autowired
    private MinSuModelMapper minSuModelMapper;

    @Autowired
    private MsImgModelMapper msImgModelMapper;


    @Override
    public List<MinSuModel> queryMinsu() {
        return minSuModelMapper.queryMinsu();
    }

    /**
     * 查询单挑房间数据
     * @param minsuid
     * @return
     */
    @Override
    public MinSuModel queryMinsuOne(String minsuid) {
        return minSuModelMapper.queryMinsuOne(minsuid);
    }

    @Override
    public List<MsImgModel> queryMsImg(String minsuid) {
        return msImgModelMapper.queryMsImg(minsuid);
    }
}
