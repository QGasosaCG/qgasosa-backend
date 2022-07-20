package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.controller.response.BestGasStationResponse;
import com.qgasosa.backend.dto.GasStationFuelDTO;
import com.qgasosa.backend.dto.XlsDTO;
import com.qgasosa.backend.model.GasStationFuel;

import java.io.IOException;
import java.util.List;

public interface GasStationFuelService {

    void updateGasStationFuelByXLS(XlsDTO xls);

    void updateGasStationFuelPrice(Long gasStationId, GasStationFuelDTO gasStationFuelDTO);

    List<GasStationFuel> findAllGasStations();
}
