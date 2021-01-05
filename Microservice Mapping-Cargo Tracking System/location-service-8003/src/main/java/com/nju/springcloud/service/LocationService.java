package com.nju.springcloud.service;


import com.nju.springcloud.entities.locationVersion2.LocationVersion2;

public interface LocationService {
    /**
     * add new location into system
     * @param location
     * @return
     */
    public int CreateLocation(LocationVersion2 location);

}
