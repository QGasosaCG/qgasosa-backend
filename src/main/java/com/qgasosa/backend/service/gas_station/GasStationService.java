package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.model.GasStation;

import com.qgasosa.backend.controller.response.GasStationDistanceResponse;
import java.io.IOException;
import java.util.List;

public interface GasStationService {

    List<GasStation> findAllGasStations();

    GasStation findGasStationByName(String name);

    public List<GasStation> findAllGasStation();

    GasStation findGasStationById(Long id);

    GasStation addGasStation(GasStationDTO gasStationDTO);

    GasStation updateGasStation(Long id, GasStationDTO gasStationDTO);

    void saveGasStation(GasStation gasStation);

    List<GasStationDistanceResponse> findClosestGasStations(String gasStationLat, String gasStationLong) throws IOException;
}
