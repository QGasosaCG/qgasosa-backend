package com.qgasosa.backend.repository;

import com.qgasosa.backend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findByName(String name);
}
