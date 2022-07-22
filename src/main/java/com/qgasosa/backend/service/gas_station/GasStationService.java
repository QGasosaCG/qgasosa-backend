package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.controller.response.gas_station.CheapestGasStationResponse;
import com.qgasosa.backend.controller.response.gas_station.ClosestGasStationResponse;
import com.qgasosa.backend.controller.response.BestGasStationResponse;
import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.model.GasStation;

import java.io.IOException;
import java.util.List;

public interface GasStationService {

    List<GasStation> findAllGasStations();

    GasStation findGasStationByName(String name);

    GasStation findGasStationById(Long id);

    GasStation createGasStation(GasStationDTO gasStationDTO);

    GasStation createGasStation(String gasStationName, String gasStationStreet);

    void updateGasStation(Long id, GasStationDTO gasStationDTO);

    GasStation saveGasStation(GasStation gasStation);

    List<ClosestGasStationResponse> findClosestGasStations(String originLatitude, String originLongitude) throws IOException;

    List<BestGasStationResponse> findBestGasStations(String originLatitude, String originLongitude, Double consumption) throws IOException;

    List<CheapestGasStationResponse> findCheapestGasStation(String fuelName);
}
