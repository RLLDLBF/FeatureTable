package com.nju.springcloud.service.impl;

import com.nju.springcloud.dao.TrackingDao;

import com.nju.springcloud.entities.cargoVersion2.CargoVersion2;
import com.nju.springcloud.service.TrackingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TrackingServiceImpl implements TrackingService {
    @Resource
    private TrackingDao trackingDao;

    public CargoVersion2 ViewTracking(String trackingId){
        return trackingDao.findById(trackingId);
    }
}
