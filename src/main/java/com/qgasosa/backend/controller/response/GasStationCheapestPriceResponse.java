package com.qgasosa.backend.controller.response;

import com.qgasosa.backend.model.GasStation;

public class GasStationCheapestPriceResponse implements Comparable<GasStationCheapestPriceResponse> {

    private GasStation gasStation;

    private Double price;

    public GasStationCheapestPriceResponse() {
    }

    public GasStationCheapestPriceResponse(GasStation gasStation, Double price) {
        this.gasStation = gasStation;
        this.price = price;
    }

    public GasStation getGasStation() {
        return gasStation;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public int compareTo(GasStationCheapestPriceResponse gasStationCheapestPriceResponse) {
        return this.getPrice().compareTo(gasStationCheapestPriceResponse.getPrice());
    }
}
