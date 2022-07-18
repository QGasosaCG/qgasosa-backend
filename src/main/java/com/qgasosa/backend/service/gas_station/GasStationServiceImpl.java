package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.controller.response.BestGasStationResponse;
import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.exception.gas_station.GasStationAlreadyExistsException;
import com.qgasosa.backend.controller.response.GasStationDistanceResponse;
import com.qgasosa.backend.exception.gas_station.GasStationNotFoundException;
import com.qgasosa.backend.maps.MapsClient;
import com.qgasosa.backend.maps.response.MapsMetricResponse;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.model.GasStationFuel;
import com.qgasosa.backend.repository.GasStationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GasStationServiceImpl implements GasStationService {

    private final Logger logger = LogManager.getLogger(GasStationServiceImpl.class);

    @Autowired
    private GasStationRepository gasStationRepository;

    @Autowired
    private GasStationFuelService gasStationFuelService;

    @Autowired
    private MapsClient mapsClient;

    @Override
    public List<GasStation> findAllGasStations() {
        return this.gasStationRepository.findAll();
    }

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
    public GasStation createGasStation(GasStationDTO gasStationDTO) {
        Optional<GasStation> gasStationOp = this.gasStationRepository.findByName(gasStationDTO.name());

        if(gasStationOp.isPresent()){
            throw new GasStationAlreadyExistsException(gasStationDTO.name());
        }

        GasStation gasStation = new GasStation(gasStationDTO.name(), gasStationDTO.address());

        this.saveGasStation(gasStation);

        return gasStation;
    }

    @Override
    @Transactional
    public GasStation updateGasStation(Long id, GasStationDTO gasStationDTO) {
        GasStation gasStation = this.findGasStationById(id);

        if(gasStation == null) {
            throw new GasStationNotFoundException(gasStationDTO.name());
        }

        gasStation.setAddress(gasStationDTO.address());
        gasStation.setName(gasStationDTO.name());

        this.saveGasStation(gasStation);

        return gasStation;
    }

    @Override
    @Transactional
    public void saveGasStation(GasStation gasStation) {
        this.gasStationRepository.save(gasStation);
    }

    @Override
    public List<GasStationDistanceResponse> findClosestGasStations(String originLatitude, String originLongitude) throws IOException {
        List<GasStation> gasStations = this.findAllGasStations();
        List<GasStationDistanceResponse> closestGasStations = new ArrayList<>();

        for (GasStation gasStation: gasStations) {
            MapsMetricResponse distance = mapsClient.getDistance(originLatitude, originLongitude, gasStation);
            closestGasStations.add(new GasStationDistanceResponse(gasStation, distance));
        }

        Collections.sort(closestGasStations);

        return closestGasStations;
    }

    @Override
    public List<BestGasStationResponse> findBestGasStations(String originLatitude, String originLongitude, Double consumption) throws IOException {
        List<GasStationFuel> gasStationFuels = this.gasStationFuelService.findAllGasStations();
        List<BestGasStationResponse> bestGasStations = new ArrayList<>();

        for (GasStationFuel gasStationFuel : gasStationFuels) {
            Double fuelPrice = gasStationFuel.getPrice();
            if (!fuelPrice.equals(0.0)) {
                MapsMetricResponse distance =  mapsClient.getDistance(originLatitude, originLongitude, gasStationFuel.getGasStation());
                Double cost = this.calculateCost(distance, consumption, gasStationFuel.getPrice());
                bestGasStations.add(new BestGasStationResponse(gasStationFuel, distance, cost));
            }
        }

        Collections.sort(bestGasStations);
        return bestGasStations;
    }

    private Double calculateCost(MapsMetricResponse distance, Double consumption, Double price) {
        return ((distance.getValue() / 1000) / consumption) * price;
    }
}
