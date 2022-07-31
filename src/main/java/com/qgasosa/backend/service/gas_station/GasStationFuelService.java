package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.dto.UpdateGasStationFuelDTO;
import com.qgasosa.backend.dto.XlsDTO;
import com.qgasosa.backend.model.GasStationFuel;

import java.util.List;

public interface GasStationFuelService {

    void updateGasStationFuelByXLS(XlsDTO xls);

    void updateGasStationFuelPrice(Long gasStationId, UpdateGasStationFuelDTO gasStationFuelDTO);

    List<GasStationFuel> findAllGasStations();

    List<GasStationFuel> findAllGasStationsByFuelName(String fuelName);
}
