package com.qgasosa.backend.controller.response;

import com.qgasosa.backend.maps.response.MapsMetricResponse;
import com.qgasosa.backend.model.Fuel;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.model.GasStationFuel;


public class BestGasStationResponse implements Comparable<BestGasStationResponse> {

    private GasStationFuel gasStationFuel;

    private MapsMetricResponse distance;

    private Double cost;

    public BestGasStationResponse(GasStationFuel gasStationFuel, MapsMetricResponse distance, Double cost) {
        this.gasStationFuel = gasStationFuel;
        this.distance = distance;
        this.cost = cost;
    }

    public GasStation getGasStation() {
        return gasStationFuel.getGasStation();
    }

    public GasStationFuel getFuel() {
        return gasStationFuel;
    }

    public MapsMetricResponse getDistance() {
        return distance;
    }

    public Double getCost() {
        return cost;
    }

    @Override
    public int compareTo(BestGasStationResponse bestGasStationResponse) {
        return cost.compareTo(bestGasStationResponse.getCost());
    }
}
