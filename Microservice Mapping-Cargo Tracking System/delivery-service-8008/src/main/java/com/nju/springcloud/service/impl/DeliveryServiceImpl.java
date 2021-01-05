package com.nju.springcloud.service.impl;

import com.nju.springcloud.dao.DeliveryDao;
import com.nju.springcloud.entities.cargoVersion2.CargoVersion2;
import com.nju.springcloud.service.DeliveryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Resource
    private DeliveryDao deliveryDao;

    public int UpdateCargoLocation(CargoVersion2 cargo){
//        return deliveryDao.updateCurrentLocation(cargo);
        int result = deliveryDao.updateCurrentLocation(cargo);
        deliveryDao.updateCargoState(cargo);
        return result;
    }
}
