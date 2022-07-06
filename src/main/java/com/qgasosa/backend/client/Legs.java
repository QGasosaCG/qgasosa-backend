package com.qgasosa.backend.client;


public class Legs {
    private Metric distance;
    private Metric duration;

    public Metric getDistance() {
        return distance;
    }

    public void setDistance(Metric distance) {
        this.distance = distance;
    }

    public Metric getDuration() {
        return duration;
    }

    public void setDuration(Metric duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "RouteSubType{" +
                "distance=" + distance +
                ", duration=" + duration +
                '}';
    }
}
