package com.qgasosa.backend.repository;

import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.model.GasStationFuel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GasStationFuelRepository extends JpaRepository<GasStationFuel, Long> {

    Optional<GasStationFuel> findByGasStation(GasStation gasStation);
}
