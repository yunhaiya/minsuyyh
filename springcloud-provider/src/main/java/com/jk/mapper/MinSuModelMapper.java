package com.jk.mapper;

import com.jk.model.MinSuModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MinSuModelMapper {
    List<MinSuModel> queryMinsu();

    MinSuModel queryMinsuOne(@Param("minsuid") String minsuid);
}