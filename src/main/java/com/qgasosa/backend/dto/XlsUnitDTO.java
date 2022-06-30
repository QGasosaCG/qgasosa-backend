package com.qgasosa.backend.dto;

public class XlsUnitDTO {

    private String gasStationName;

    private String gasStationStreet;

    private String fuelName;

    private Double newPrice;

    public String getGasStationName() {
        return gasStationName;
    }

    public String getGasStationStreet() {
        return gasStationStreet;
    }

    public void setGasStationStreet(String gasStationStreet) {
        this.gasStationStreet = gasStationStreet;
    }

    public void setGasStationName(String gasStationName) {
        this.gasStationName = gasStationName;
    }

    public String getFuelName() {
        return fuelName;
    }

    public void setFuelName(String fuelName) {
        this.fuelName = fuelName;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
        this.newPrice = newPrice;
    }

    @Override
    public String toString() {
        return gasStationName + ", " + gasStationStreet + ", " + fuelName + ", " + newPrice;
    }
}
