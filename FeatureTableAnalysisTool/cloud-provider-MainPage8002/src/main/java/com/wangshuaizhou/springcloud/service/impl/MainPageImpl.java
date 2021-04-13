package com.wangshuaizhou.springcloud.service.impl;

import com.wangshuaizhou.springcloud.dao.MainPageDao;
import com.wangshuaizhou.springcloud.entities.FeatureWeight;
import com.wangshuaizhou.springcloud.service.MainPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MainPageImpl implements MainPageService{
    @Resource
    private MainPageDao mainPageDao;

    public List<FeatureWeight> SelectAllFeatureWeight() {
        return mainPageDao.SelectAllFeatureWeight();
    }
}
