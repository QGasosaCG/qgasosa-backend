package com.qgasosa.backend.repository;

import com.qgasosa.backend.model.Fuel;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.model.GasStationFuel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface GasStationFuelRepository extends JpaRepository<GasStationFuel, Long> {

    List<GasStationFuel> findByGasStation(GasStation gasStation);

    List<GasStationFuel> findByFuel(Fuel fuel);
}
