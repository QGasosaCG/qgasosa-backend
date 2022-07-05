package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.exception.gas_station.GasStationNotFoundException;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.repository.GasStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GasStationServiceImpl implements GasStationService {

    @Autowired
    private GasStationRepository gasStationRepository;

    @Override
    public GasStation findGasStationByName(String name) {
        return this.gasStationRepository.findByName(name).orElseThrow(() -> new GasStationNotFoundException(name));
    }

    @Override
    public GasStation findGasStationById(Long id) {
        return this.gasStationRepository.findById(id).orElseThrow(() -> new GasStationNotFoundException(id));
    }

    @Override
    @Transactional
    public void saveGasStation(GasStation gasStation) {
        this.gasStationRepository.save(gasStation);
    }
}
