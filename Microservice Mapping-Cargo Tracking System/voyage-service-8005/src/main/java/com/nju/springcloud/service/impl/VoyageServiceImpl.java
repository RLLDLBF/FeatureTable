package com.nju.springcloud.service.impl;

import com.nju.springcloud.dao.VoyageDao;
import com.nju.springcloud.entities.voyageVersion2.CarrierMovementVersion2;
import com.nju.springcloud.entities.voyageVersion2.VoyageVersion2;
import com.nju.springcloud.service.VoyageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VoyageServiceImpl implements VoyageService {
    @Resource
    private VoyageDao voyageDao;

    public int CreateVoyage(VoyageVersion2 voyage){
        return voyageDao.createVoyage(voyage);
    }

    public int AddCarrierMovement(CarrierMovementVersion2 carrierMovement){
        return voyageDao.createCarrierMovement(carrierMovement);
    }

}
