package com.qgasosa.backend.controller.response.gas_station;

import com.qgasosa.backend.dto.AddressDTO;
import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.maps.response.MapsMetricResponse;
import com.qgasosa.backend.model.GasStation;

public class ClosestGasStationResponse implements Comparable<ClosestGasStationResponse> {
    private GasStationDTO gasStation;
    private MapsMetricResponse distance;

    public ClosestGasStationResponse() {
    }

    public ClosestGasStationResponse(GasStation gasStation, MapsMetricResponse distance) {
        AddressDTO addressDTO = new AddressDTO(gasStation.getAddress().getName(), gasStation.getAddress().getLatitude(), gasStation.getAddress().getLatitude());
        this.gasStation = new GasStationDTO(gasStation.getName(), addressDTO);
        this.distance = distance;
    }

    public GasStationDTO getGasStation() {
        return gasStation;
    }

    public MapsMetricResponse getDistance() {
        return distance;
    }

    @Override
    public int compareTo(ClosestGasStationResponse closestGasStationResponse) {
        return this.getDistance().getValue().compareTo(closestGasStationResponse.getDistance().getValue());
    }
}
