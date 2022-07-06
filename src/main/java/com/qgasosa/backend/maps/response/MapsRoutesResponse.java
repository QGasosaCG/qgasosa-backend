package com.qgasosa.backend.maps.response;

import java.util.List;

public class MapsRoutesResponse {
    private List<MapsLegResponse> legs;

    public List<MapsLegResponse> getLegs() {
        return legs;
    }
    public MapsMetricResponse getDistanceMetric() {
        return legs.get(0).getDistance();
    }

    @Override
    public String toString() {
        return "Routes{" +
                "legs=" + legs +
                '}';
    }
}
