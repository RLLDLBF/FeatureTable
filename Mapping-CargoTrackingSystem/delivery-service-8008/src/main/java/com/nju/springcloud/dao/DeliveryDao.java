package com.nju.springcloud.dao;

import com.nju.springcloud.entities.cargoVersion2.CargoVersion2;
import org.apache.ibatis.annotations.Update;

public interface DeliveryDao {
    @Update("update cargo set currentLocation = #{currentLocation} where trackingId = #{trackingId}")
    Integer updateCurrentLocation(CargoVersion2 cargo);

    @Update("update cargo set cargoState = 1 where (currentLocation = destinationLocationName and trackingId = #{trackingId})")
    Integer updateCargoState(CargoVersion2 cargo);
}
