package com.qgasosa.backend.service.fuel;

import com.qgasosa.backend.model.Fuel;

public interface FuelService {

    Fuel findFuelByName(String name);

    Fuel findFuelById(Long id);

    void saveFuel(Fuel fuel);

}
