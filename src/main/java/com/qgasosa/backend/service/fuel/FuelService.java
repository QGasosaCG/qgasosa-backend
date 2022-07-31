package com.qgasosa.backend.service.fuel;

import com.qgasosa.backend.dto.FuelDTO;
import com.qgasosa.backend.model.Fuel;

import java.util.List;

public interface FuelService {

    List<FuelDTO> findAllFuels();

    Fuel findFuelByName(String name);

    Fuel findFuelById(Long id);

    void saveFuel(Fuel fuel);

}
