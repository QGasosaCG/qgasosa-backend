package com.qgasosa.backend.maps.response;


public class MapsLegResponse {
    private MapsMetricResponse distance;
    private MapsMetricResponse duration;

    public MapsMetricResponse getDistance() {
        return distance;
    }

    public MapsMetricResponse getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "RouteSubType{" +
                "distance=" + distance +
                ", duration=" + duration +
                '}';
    }
}
