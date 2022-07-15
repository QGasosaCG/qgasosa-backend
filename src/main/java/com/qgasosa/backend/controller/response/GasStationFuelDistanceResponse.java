package com.qgasosa.backend.controller.response;

import com.qgasosa.backend.maps.response.MapsMetricResponse;
import com.qgasosa.backend.model.GasStationFuel;


public class GasStationFuelDistanceResponse implements Comparable<GasStationFuelDistanceResponse> {

    private GasStationFuel gasStationFuel;

    private MapsMetricResponse distance;

    private Double cost;

    public GasStationFuelDistanceResponse(GasStationFuel gasStationFuel, MapsMetricResponse distance, Double cost) {
        this.gasStationFuel = gasStationFuel;
        this.distance = distance;
        this.cost = cost;
    }

    public GasStationFuel getGasStationFuel() {
        return gasStationFuel;
    }

    public MapsMetricResponse getDistance() {
        return distance;
    }

    public Double getCost() {
        return cost;
    }

    @Override
    public int compareTo(GasStationFuelDistanceResponse gasStationFuelDistanceResponse) {
        return this.getDistance().getValue().compareTo(gasStationFuelDistanceResponse.getDistance().getValue());
    }
}
