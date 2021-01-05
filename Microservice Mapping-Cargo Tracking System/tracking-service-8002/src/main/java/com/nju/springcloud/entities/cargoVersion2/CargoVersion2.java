package com.nju.springcloud.entities.cargoVersion2;

import java.sql.Date;

public class CargoVersion2 {
    private String trackingId;
    private String originLocationName;
    private String destinationLocationName;
    private Date arrivalDeadline;
    private String currentLocation;
    private int cargoState;

    /**
     * TODO: Voyage List
     */

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getOriginLocationName() {
        return originLocationName;
    }

    public void setOriginLocationName(String originLocationName) {
        this.originLocationName = originLocationName;
    }

    public String getDestinationLocationName() {
        return destinationLocationName;
    }

    public void setDestinationLocationName(String destinationLocationName) {
        this.destinationLocationName = destinationLocationName;
    }

    public Date getArrivalDeadline() {
        return arrivalDeadline;
    }

    public void setArrivalDeadline(Date arrivalDeadline) {
        this.arrivalDeadline = arrivalDeadline;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public int getCargoState() {
        return cargoState;
    }

    public void setCargoState(int cargoState) {
        this.cargoState = cargoState;
    }
}
