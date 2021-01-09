package com.nju.springcloud.dao;

import com.nju.springcloud.entities.cargoVersion2.CargoVersion2;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TrackingDao {

    /**
     * cargo table
     * @param trackingId
     * @return
     */
    @Select("select * from cargo where trackingId=#{trackingId}")
    CargoVersion2 findById(@Param("trackingId") String trackingId);
}