package com.nju.springcloud.service.impl;

import com.nju.springcloud.dao.CargoDao;


import com.nju.springcloud.entities.cargoVersion2.CargoVersion2;
import com.nju.springcloud.service.CargoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {
    @Resource
    private CargoDao cargoDao;

    public List<CargoVersion2> ListAllCargos(){
        return cargoDao.findAll();
    }

    public CargoVersion2 ViewDetailsForCargo(String trackingId){
        return cargoDao.findById(trackingId);
    }

    public int BookCargo(CargoVersion2 cargo){
        return cargoDao.create(cargo);
    }

    public int ChangeCargoDestination(CargoVersion2 cargo){
        int result = cargoDao.updateDestinationLocation(cargo);
        cargoDao.updateCargoState2One(cargo);
        cargoDao.updateCargoState2Zero(cargo);
        return result;
    }

    //TODO: to realize RouteCargo
    public int RouteCargo(CargoVersion2 cargo){
        return 0;
    }
}

