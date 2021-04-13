package com.wangshuaizhou.springcloud.dao;

import com.wangshuaizhou.springcloud.entities.FeatureWeight;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MainPageDao {
    @Select("select * from featureweight")
    public List<FeatureWeight> SelectAllFeatureWeight();
}
