package com.qgasosa.backend.maps.response;

import java.util.List;

public class MapsResponse {
    private List<MapsRoutesResponse> routes;

    public List<MapsRoutesResponse> getRoutes() {
        return routes;
    }

    public MapsMetricResponse getDistance() {
        return routes.get(0).getDistanceMetric();
    }

    public boolean fail() {
        return this.routes.isEmpty();
    }

    @Override
    public String toString() {
        return "Response{" +
                "routes=" + routes +
                '}';
    }
}
