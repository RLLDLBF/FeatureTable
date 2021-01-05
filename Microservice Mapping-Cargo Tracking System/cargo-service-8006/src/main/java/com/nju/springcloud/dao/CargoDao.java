package com.nju.springcloud.dao;

import com.nju.springcloud.entities.cargoVersion2.CargoVersion2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CargoDao {
    @Select("select * from cargo")
    List<CargoVersion2> findAll();

    @Select("select * from cargo where trackingId=#{trackingId}")
    CargoVersion2 findById(@Param("trackingId") String trackingId);

    @Insert("insert into cargo(trackingId,cargoName,"+
            "originLocationName,destinationLocationName,"+
            "arrivalDeadline,"+
            "currentLocation,cargoState) "+
            "values(#{trackingId},#{cargoName},"+
            "#{originLocationName},#{destinationLocationName},"+
            "#{arrivalDeadline},"+
            "#{currentLocation},#{cargoState})")
    Integer create(CargoVersion2 cargo);

    @Update("update cargo set destinationLocationName = #{destinationLocationName} where trackingId = #{trackingId}")
    Integer updateDestinationLocation(CargoVersion2 cargo);

    @Update("update cargo set cargoState = 1 where (currentLocation = destinationLocationName and trackingId = #{trackingId})")
    Integer updateCargoState2One(CargoVersion2 cargo);

    @Update("update cargo set cargoState = 0 where (currentLocation != destinationLocationName and trackingId = #{trackingId})")
    Integer updateCargoState2Zero(CargoVersion2 cargo);


}
