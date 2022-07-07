package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.controller.response.ClosestGasStationResponse;
import com.qgasosa.backend.exception.ApiExceptionHandler;
import com.qgasosa.backend.exception.gas_station.GasStationNotFoundException;
import com.qgasosa.backend.maps.MapsClient;
import com.qgasosa.backend.maps.response.MapsMetricResponse;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.repository.GasStationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class GasStationServiceImpl implements GasStationService {

    @Autowired
    private GasStationRepository gasStationRepository;

    @Autowired
    private MapsClient mapsClient;

    @Override
    public List<GasStation> getAllGasStations() {
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
    public void saveGasStation(GasStation gasStation) {
        this.gasStationRepository.save(gasStation);
    }

    @Override
    public List<ClosestGasStationResponse> getClosestGasStation(String originLatitude, String originLongitude)
            throws IOException {
        List<GasStation> gasStations = this.getAllGasStations();
        List<ClosestGasStationResponse> closestGasStations = new ArrayList<>();

        for (GasStation gasStation: gasStations) {
            MapsMetricResponse distance = mapsClient.getDistance(originLatitude, originLongitude, gasStation);
            closestGasStations.add(new ClosestGasStationResponse(distance.getValue(), gasStation));
        }

        Collections.sort(closestGasStations);

        return closestGasStations;
    }
}
