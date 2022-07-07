package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.controller.response.ClosestGasStationResponse;
import com.qgasosa.backend.model.GasStation;

import java.io.IOException;
import java.util.List;

public interface GasStationService {

    List<GasStation> getAllGasStations();

    GasStation findGasStationByName(String name);

    GasStation findGasStationById(Long id);

    void saveGasStation(GasStation gasStation);

    List<ClosestGasStationResponse> getClosestGasStation(String gasStationLat, String gasStationLong) throws IOException;
}
