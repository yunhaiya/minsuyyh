package com.jk.mapper;


import com.jk.model.MsImgModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MsImgModelMapper {

    List<MsImgModel> queryMsImg(@Param("mspid") String minsuid);
}