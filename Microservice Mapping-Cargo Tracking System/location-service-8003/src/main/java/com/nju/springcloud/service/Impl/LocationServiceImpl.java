package com.nju.springcloud.service.Impl;

import com.nju.springcloud.dao.LocationDao;

import com.nju.springcloud.entities.locationVersion2.LocationVersion2;
import com.nju.springcloud.service.LocationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LocationServiceImpl implements LocationService {
    @Resource
    private LocationDao locationDao;

    public int CreateLocation(LocationVersion2 location){
        return locationDao.create(location);
    }
}
