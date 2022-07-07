package com.qgasosa.backend.controller.response;

import com.qgasosa.backend.model.GasStation;

public class ClosestGasStationResponse implements Comparable<ClosestGasStationResponse> {
    private Integer distance;
    private GasStation gasStation;

    public ClosestGasStationResponse() {
    }

    public ClosestGasStationResponse(Integer distance, GasStation gasStation) {
        this.distance = distance;
        this.gasStation = gasStation;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public GasStation getGasStation() {
        return gasStation;
    }

    public void setGasStation(GasStation gasStation) {
        this.gasStation = gasStation;
    }

    @Override
    public int compareTo(ClosestGasStationResponse closestGasStationResponse) {
        return this.getDistance().compareTo(closestGasStationResponse.getDistance());
    }
}
