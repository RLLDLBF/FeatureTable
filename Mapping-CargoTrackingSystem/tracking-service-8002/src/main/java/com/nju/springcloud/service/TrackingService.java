package com.nju.springcloud.service;

import com.nju.springcloud.entities.cargoVersion2.CargoVersion2;
import org.apache.ibatis.annotations.Param;

public interface TrackingService {
    public CargoVersion2 ViewTracking(@Param("trackingId") String trackingId);
}
