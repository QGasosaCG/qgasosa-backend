package com.qgasosa.backend.controller.response;

import com.qgasosa.backend.maps.response.MapsMetricResponse;
import com.qgasosa.backend.model.GasStation;

public class GasStationDistanceResponse implements Comparable<GasStationDistanceResponse> {
    private GasStation gasStation;
    private MapsMetricResponse distance;

    public GasStationDistanceResponse() {
    }

    public GasStationDistanceResponse(GasStation gasStation, MapsMetricResponse distance) {
        this.gasStation = gasStation;
        this.distance = distance;
    }

    public GasStation getGasStation() {
        return gasStation;
    }

    public MapsMetricResponse getDistance() {
        return distance;
    }

    @Override
    public int compareTo(GasStationDistanceResponse gasStationDistanceResponse) {
        return this.getDistance().getValue().compareTo(gasStationDistanceResponse.getDistance().getValue());
    }
}
