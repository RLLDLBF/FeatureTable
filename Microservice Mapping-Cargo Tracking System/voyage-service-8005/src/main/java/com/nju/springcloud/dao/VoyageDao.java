package com.nju.springcloud.dao;

import com.nju.springcloud.entities.voyageVersion2.CarrierMovementVersion2;
import com.nju.springcloud.entities.voyageVersion2.VoyageVersion2;
import org.apache.ibatis.annotations.Insert;

public interface VoyageDao {
    /**
     * TODO: add voyage elements
     * @param voyage
     * @return
     */
    @Insert("insert into voyage(voyageNumber) values(#{voyageNumber})")
    Integer createVoyage(VoyageVersion2 voyage);

    /**
     * TODO: add carrierMovement elements
     * @param carrierMovement
     * @return
     */
    @Insert("insert into carriermovement(carrierMovementId,"+
            "departureLocationName,arrivalLocationName,"+
            "departureTime,arrivalTime) "+
            "values(#{carrierMovementId},"+
            "#{departureLocationName},#{arrivalLocationName},"+
            "#{departureTime},#{arrivalTime})")
    Integer createCarrierMovement(CarrierMovementVersion2 carrierMovement);

}

