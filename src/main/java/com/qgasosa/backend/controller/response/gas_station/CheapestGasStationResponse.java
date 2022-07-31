package com.qgasosa.backend.controller.response.gas_station;

import com.qgasosa.backend.dto.AddressDTO;
import com.qgasosa.backend.dto.FuelPriceDTO;
import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.model.GasStationFuel;

public class CheapestGasStationResponse {

    private final GasStationDTO gasStation;

    private final FuelPriceDTO fuel;

    public CheapestGasStationResponse(GasStationFuel gasStationFuel) {
        AddressDTO addressDTO = this.buildAddress(gasStationFuel.getGasStation());
        this.gasStation = new GasStationDTO(gasStationFuel.getGasStation().getName(), addressDTO);
        this.fuel = new FuelPriceDTO(gasStationFuel.getFuelName(), gasStationFuel.getPrice());
    }

    private AddressDTO buildAddress(GasStation gasStation) {
        return new AddressDTO(
                gasStation.getAddress().getName(),
                gasStation.getAddress().getLatitude(),
                gasStation.getAddress().getLongitude()
        );
    }

    public GasStationDTO getGasStation() {
        return gasStation;
    }

    public FuelPriceDTO getFuel() {
        return fuel;
    }
}
