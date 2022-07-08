package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.model.GasStation;

import java.util.List;

public interface GasStationService {

    GasStation findGasStationByName(String name);

    public List<GasStation> findAllGasStation();

    GasStation findGasStationById(Long id);

    GasStation addGasStation(GasStationDTO gasStationDTO);

    GasStation updateGasStation(Long id, GasStationDTO gasStationDTO);

    void saveGasStation(GasStation gasStation);

}
