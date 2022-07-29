package com.qgasosa.backend.service.admin;

import com.qgasosa.backend.dto.BatchGasStationFuelDTO;
import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.dto.GasStationFuelDTO;
import com.qgasosa.backend.dto.XlsDTO;
import com.qgasosa.backend.model.GasStation;

public interface AdminService {

    GasStation createGasStation(GasStationDTO gasStationDTO);

    void updateGasStationFuelPrice(Long gasStationId, BatchGasStationFuelDTO gasStationFuelDTO);

    void updateGasStationFuelPrice(Long gasStationId, GasStationFuelDTO gasStationFuelDTO);

    void updateGasStation(Long gasStationId, GasStationDTO gasStationDTO);

    void updateGasStationFuelByXLS(XlsDTO xlsDTO);
}
