package com.qgasosa.backend.controller.response;

import com.qgasosa.backend.dto.FuelDTO;
import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.model.GasStationFuel;

public class CheapestGasStationResponse {

    private GasStationDTO gasStation;

    private FuelDTO fuel;

    private Double price;

    public CheapestGasStationResponse() {
    }

    public CheapestGasStationResponse(GasStationFuel gasStationFuel) {
        this.gasStation = new GasStationDTO(gasStationFuel.getGasStation().getName(), gasStationFuel.getGasStation().getAddress());
        this.fuel = new FuelDTO(gasStationFuel.getFuelName());
        this.price = gasStationFuel.getPrice();
    }

    public GasStationDTO getGasStation() {
        return gasStation;
    }

    public FuelDTO getFuel() {
        return fuel;
    }

    public Double getPrice() {
        return price;
    }

}
