package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.controller.response.GasStationFuelDistanceResponse;
import com.qgasosa.backend.dto.GasStationFuelDTO;
import com.qgasosa.backend.dto.XlsDTO;

import java.io.IOException;
import java.util.List;

public interface GasStationFuelService {

    void updateGasStationFuelByXLS(XlsDTO xls);

    void updateGasStationFuelPrice(Long gasStationId, GasStationFuelDTO gasStationFuelDTO);

    List<GasStationFuelDistanceResponse> findBetterGasStations(String gasStationLat, String gasStationLong, Double consumption) throws IOException;
}
