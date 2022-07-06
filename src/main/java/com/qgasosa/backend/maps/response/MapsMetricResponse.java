package com.qgasosa.backend.maps.response;

public class MapsMetricResponse {
    private String text;
    private Integer value;

    public String getText() {
        return text;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "text='" + text + '\'' +
                ", value=" + value +
                '}';
    }
}
