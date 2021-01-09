package com.nju.springcloud.service;

import com.nju.springcloud.entities.cargoVersion2.CargoVersion2;

public interface DeliveryService {
    /**
     *
     * @param cargo
     * @return
     */
    public int UpdateCargoLocation(CargoVersion2 cargo);
}
