package com.qgasosa.backend.service.fuel;

import com.qgasosa.backend.model.Fuel;
import com.qgasosa.backend.repository.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FuelServiceImpl implements FuelService {

    @Autowired
    private FuelRepository fuelRepository;

    @Override
    public Fuel findFuelByName(String name) {
        return this.fuelRepository.findByName(name).orElse(null);
    }

    @Override
    public Fuel findFuelById(Long id) {
        return this.fuelRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void saveFuel(Fuel fuel) {
        this.fuelRepository.save(fuel);
    }
}
