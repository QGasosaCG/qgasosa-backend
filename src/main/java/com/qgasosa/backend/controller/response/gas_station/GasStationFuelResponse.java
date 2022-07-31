package com.qgasosa.backend.controller.response.gas_station;

import com.qgasosa.backend.dto.AddressDTO;
import com.qgasosa.backend.dto.FuelPriceDTO;
import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.model.GasStation;

import java.util.Collection;
import java.util.stream.Collectors;

public class GasStationFuelResponse {

    private GasStationDTO gasStation;

    private Collection<FuelPriceDTO> fuels;

    public GasStationFuelResponse() {}

    public GasStationFuelResponse(GasStation gasStation) {
        AddressDTO addressDTO = new AddressDTO(gasStation.getAddress().getName(), gasStation.getAddress().getLatitude(), gasStation.getAddress().getLatitude());
        this.gasStation = new GasStationDTO(gasStation.getName(), addressDTO);
        this.fuels = this.parseFuelPrices(gasStation);
    }

    private Collection<FuelPriceDTO> parseFuelPrices(GasStation gasStation) {
        return gasStation
                .getFuels()
                .stream()
                .filter(gasStationFuel -> gasStationFuel.getPrice() > 0.0)
                .map(gasStationFuel -> new FuelPriceDTO(gasStationFuel.getFuelName(), gasStationFuel.getPrice()))
                .collect(Collectors.toList());
    }

    public GasStationDTO getGasStation() {
        return gasStation;
    }

    public Collection<FuelPriceDTO> getFuels() {
        return fuels;
    }

    @Override
    public String toString() {
        return "GasStationFuelResponse{" +
                "gasStation=" + gasStation +
                ", fuels=" + fuels +
                '}';
    }
}
