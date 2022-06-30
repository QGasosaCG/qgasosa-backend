package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.model.GasStation;

public interface GasStationService {

    GasStation findGasStationByName(String name);

    GasStation findGasStationById(Long id);

    void saveGasStation(GasStation gasStation);

}
