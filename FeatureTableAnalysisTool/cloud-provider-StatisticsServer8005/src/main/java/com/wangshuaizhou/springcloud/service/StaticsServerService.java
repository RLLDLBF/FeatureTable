package com.wangshuaizhou.springcloud.service;

import com.wangshuaizhou.springcloud.entities.FeatureTable;
import com.wangshuaizhou.springcloud.entities.FeatureWeight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaticsServerService {

    public int InsertFeatureTable(FeatureTable featureTable);

    public int UpdateFeatureWeight(FeatureWeight featureWeight);

    public List<FeatureWeight> SelectAllFeatureWeight();

    public int UpdateFeatureWeightByMysql(String featureweightname);

}
