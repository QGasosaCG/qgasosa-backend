package com.qgasosa.backend.repository;

import com.qgasosa.backend.model.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuelRepository extends JpaRepository<Fuel, Long> {

    Optional<Fuel> findByName(String name);
}
