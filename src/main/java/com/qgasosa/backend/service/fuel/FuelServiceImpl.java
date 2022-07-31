package com.qgasosa.backend.service.fuel;

import com.qgasosa.backend.dto.FuelDTO;
import com.qgasosa.backend.exception.fuel.FuelNotFoundException;
import com.qgasosa.backend.model.Fuel;
import com.qgasosa.backend.repository.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FuelServiceImpl implements FuelService {

    @Autowired
    private FuelRepository fuelRepository;

    @Override
    public List<FuelDTO> findAllFuels() {
        return fuelRepository.
                findAll()
                .stream()
                .map(fuel -> new FuelDTO(fuel.getName()))
                .toList();
    }

    @Override
    public Fuel findFuelByName(String name) {
        return this.fuelRepository.findByName(name).orElseThrow(() -> new FuelNotFoundException(name));
    }

    @Override
    public Fuel findFuelById(Long id) {
        return this.fuelRepository.findById(id).orElseThrow(() -> new FuelNotFoundException(id));
    }

    @Override
    @Transactional
    public void saveFuel(Fuel fuel) {
        this.fuelRepository.save(fuel);
    }
}
