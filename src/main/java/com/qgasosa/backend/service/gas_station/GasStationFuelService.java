package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.dto.XlsDTO;

public interface GasStationFuelService {

    void addFuelToGasStation(Long gasStationId, Long fuelId, Double price);

    void updateGasStationFuel(String gasStationName, String fuelName, Double price);

    void updateGasStationFuelByXLS(XlsDTO xls);
}
