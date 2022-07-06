package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.dto.GasStationFuelDTO;
import com.qgasosa.backend.dto.XlsDTO;

public interface GasStationFuelService {

    void updateGasStationFuelByXLS(XlsDTO xls);

    void updateGasStationFuelPrice(Long gasStationId, GasStationFuelDTO gasStationFuelDTO);

}
