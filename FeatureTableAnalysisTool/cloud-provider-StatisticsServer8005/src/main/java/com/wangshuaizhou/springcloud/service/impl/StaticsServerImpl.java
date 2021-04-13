package com.wangshuaizhou.springcloud.service.impl;

import com.wangshuaizhou.springcloud.dao.StaticsServerDao;
import com.wangshuaizhou.springcloud.entities.FeatureTable;
import com.wangshuaizhou.springcloud.entities.FeatureWeight;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.wangshuaizhou.springcloud.service.StaticsServerService;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class StaticsServerImpl implements StaticsServerService{

    @Resource
    private StaticsServerDao staticsServerDao;

    public int InsertFeatureTable(FeatureTable featureTable) {
        return staticsServerDao.InsertFeatureTable(featureTable);
    }

    public int UpdateFeatureWeight(FeatureWeight featureWeight){
        return staticsServerDao.UpdateFeatureWeight(featureWeight);
    }

    public List<FeatureWeight> SelectAllFeatureWeight() {
        return staticsServerDao.SelectAllFeatureWeight();
    }

    public int UpdateFeatureWeightByMysql(String featureweight_name){
        FeatureWeight featureWeight=new FeatureWeight(0,featureweight_name,0.0);
        int featureweight_allnumber_byname=staticsServerDao.SelectFeatureWeightAllNumberByName(featureweight_name);
        int featureweight_micronumber_byname=staticsServerDao.SelectFeatureWeightMicroNumberByName(featureweight_name);
        double ratio=(double) featureweight_micronumber_byname/(double) featureweight_allnumber_byname;
        log.info("updateweight "+featureweight_name+" : "+featureweight_micronumber_byname+"/"+featureweight_allnumber_byname+"="+ratio);
        FeatureWeight featureWeight2=new FeatureWeight(0,featureweight_name,ratio);
        return staticsServerDao.UpdateFeatureWeight(featureWeight2);
    }
}
