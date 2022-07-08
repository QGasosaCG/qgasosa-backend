package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.exception.gas_station.GasSatationAlreadyExists;
import com.qgasosa.backend.exception.gas_station.GasStationNotFoundException;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.repository.GasStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

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
    public GasStation addGasStation(GasStationDTO gasStationDTO) {
        Optional<GasStation> gasStationOp = this.gasStationRepository.findByName(gasStationDTO.getName());

        if(gasStationOp.isPresent()){
            throw new GasSatationAlreadyExists(gasStationDTO.getName());
        }

        GasStation gasStation = new GasStation(gasStationDTO.getName(), gasStationDTO.getAddress());

        this.saveGasStation(gasStation);

        return gasStation;
    }

    @Override
    public List<GasStation> findAllGasStation() {
        List<GasStation> gasStations = this.gasStationRepository.findAll();

        return gasStations;
    }

    @Override
    public GasStation updateGasStation(Long id, GasStationDTO gasStationDTO) {
        GasStation gasStation = this.findGasStationById(id);

        if(gasStation == null) {
            throw new GasStationNotFoundException(gasStationDTO.getName());
        }

        gasStation.setAddress(gasStationDTO.getAddress());
        gasStation.setName(gasStationDTO.getName());

        this.saveGasStation(gasStation);

        return gasStation;
    }

    @Override
    @Transactional
    public void saveGasStation(GasStation gasStation) {
        this.gasStationRepository.save(gasStation);
    }
}
