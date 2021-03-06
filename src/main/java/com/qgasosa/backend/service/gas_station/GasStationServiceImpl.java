package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.controller.response.BestGasStationResponse;
import com.qgasosa.backend.controller.response.gas_station.CheapestGasStationResponse;
import com.qgasosa.backend.controller.response.gas_station.GasStationFuelResponse;
import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.exception.gas_station.GasStationAlreadyExistsException;
import com.qgasosa.backend.controller.response.gas_station.ClosestGasStationResponse;
import com.qgasosa.backend.exception.gas_station.GasStationNotFoundException;
import com.qgasosa.backend.maps.MapsClient;
import com.qgasosa.backend.maps.response.MapsMetricResponse;
import com.qgasosa.backend.model.Address;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.model.GasStationFuel;
import com.qgasosa.backend.repository.AddressRepository;
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
import java.util.stream.Collectors;

@Service
public class GasStationServiceImpl implements GasStationService {

    private final Logger logger = LogManager.getLogger(GasStationServiceImpl.class);

    @Autowired
    private GasStationRepository gasStationRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private GasStationFuelService gasStationFuelService;

    @Autowired
    private MapsClient mapsClient;

    @Override
    public List<GasStation> findAllGasStations() {
        return this.gasStationRepository.findAll();
    }

    @Override
    public List<GasStationFuelResponse> findAllGasStationFuels() {
        List<GasStation> gasStations = this.findAllGasStations();
        List<GasStationFuelResponse> gasStationsResponse = gasStations
                .stream()
                .map(GasStationFuelResponse::new)
                .collect(Collectors.toList());

        return gasStationsResponse;
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
        boolean existsGasStation = this.gasStationRepository.findByName(gasStationDTO.name()).isPresent();

        if (existsGasStation){
            throw new GasStationAlreadyExistsException(gasStationDTO.name());
        }

        Address address = new Address(gasStationDTO.address().street(), gasStationDTO.address().latitude(), gasStationDTO.address().longitude());
        this.addressRepository.save(address);

        GasStation gasStation = new GasStation(gasStationDTO.name(), address);
        return this.saveGasStation(gasStation);
    }

    @Override
    @Transactional
    public GasStation createGasStation(String gasStationName, String gasStationStreet, String latitude, String longitude) {
        Address address = new Address();
        address.setName(gasStationStreet);
        address.setLatitude(latitude);
        address.setLongitude(longitude);

        this.addressRepository.save(address);

        GasStation gasStation = new GasStation(gasStationName, address);
        return this.saveGasStation(gasStation);
    }

    @Override
    @Transactional
    public void updateGasStation(Long id, GasStationDTO gasStationDTO) {
        GasStation gasStation = this.findGasStationById(id);

        if (gasStationDTO.address() != null) {
            String street = gasStationDTO.address().street();
            if (street != null) {
                gasStation.getAddress().setName(street);
            }

            String latitude = gasStationDTO.address().latitude();
            if (latitude != null) {
                gasStation.getAddress().setLatitude(latitude);
            }

            String longitude = gasStationDTO.address().longitude();
            if (longitude != null) {
                gasStation.getAddress().setLongitude(longitude);
            }
        }

        if (gasStationDTO.name() != null) {
            gasStation.setName(gasStationDTO.name());
        }

        this.gasStationRepository.save(gasStation);
    }

    @Override
    @Transactional
    public GasStation saveGasStation(GasStation gasStation) {
        return this.gasStationRepository.save(gasStation);
    }

    @Override
    public List<ClosestGasStationResponse> findClosestGasStations(String originLatitude, String originLongitude) throws IOException {
        List<GasStation> gasStations = this.findAllGasStations();
        List<ClosestGasStationResponse> closestGasStations = new ArrayList<>();

        for (GasStation gasStation : gasStations) {
            MapsMetricResponse distance = mapsClient.getDistance(originLatitude, originLongitude, gasStation);
            closestGasStations.add(new ClosestGasStationResponse(gasStation, distance));
        }

        Collections.sort(closestGasStations);

        return closestGasStations;
    }

    @Override
    public List<CheapestGasStationResponse> findCheapestGasStation(String fuelName) {
        List<GasStationFuel> gasStationFuels = this.gasStationFuelService.findAllGasStationsByFuelName(fuelName);
        List<CheapestGasStationResponse> cheapestGasStationResponses = gasStationFuels
                .stream()
                .filter(gasStationFuel -> gasStationFuel.getPrice() > 0.0)
                .map(CheapestGasStationResponse::new)
                .sorted(Comparator.comparing(c -> c.getFuel().price())).collect(Collectors.toList());

        return cheapestGasStationResponses;
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
