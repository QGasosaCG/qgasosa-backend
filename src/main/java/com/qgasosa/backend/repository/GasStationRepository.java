package com.qgasosa.backend.repository;

import com.qgasosa.backend.model.GasStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GasStationRepository extends JpaRepository<GasStation, Long> {

    Optional<GasStation> findByName(String name);
}
