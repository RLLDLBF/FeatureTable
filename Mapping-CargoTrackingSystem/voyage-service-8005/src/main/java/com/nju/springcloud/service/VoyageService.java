package com.nju.springcloud.service;

import com.nju.springcloud.entities.voyageVersion2.CarrierMovementVersion2;
import com.nju.springcloud.entities.voyageVersion2.VoyageVersion2;

public interface VoyageService {
    /**
     * add new voyage into system
     * @param voyage
     * @return
     */
    public int CreateVoyage(VoyageVersion2 voyage);

    /**
     * add new carrierMovement into system
     * @param carrierMovement
     * @return
     */
    public int AddCarrierMovement(CarrierMovementVersion2 carrierMovement);
}
