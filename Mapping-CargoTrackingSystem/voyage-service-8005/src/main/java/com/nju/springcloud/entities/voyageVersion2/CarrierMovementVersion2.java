package com.nju.springcloud.entities.voyageVersion2;

import java.sql.Date;

public final class CarrierMovementVersion2 {
    private int carrierMovementId;
    private String departureLocationName;
    private String arrivalLocationName;
    private Date departureTime;
    private Date arrivalTime;

    public int getCarrierMovementId() {
        return carrierMovementId;
    }

    public void setCarrierMovementId(int carrierMovementId) {
        this.carrierMovementId = carrierMovementId;
    }

    public String getDepartureLocationName() {
        return departureLocationName;
    }

    public void setDepartureLocationName(String departureLocationName) {
        this.departureLocationName = departureLocationName;
    }

    public String getArrivalLocationName() {
        return arrivalLocationName;
    }

    public void setArrivalLocationName(String arrivalLocationName) {
        this.arrivalLocationName = arrivalLocationName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
