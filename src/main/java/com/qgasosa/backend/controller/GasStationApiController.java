package com.qgasosa.backend.controller;

import com.qgasosa.backend.controller.response.GasStationDistanceResponse;
import com.qgasosa.backend.controller.response.GasStationFuelDistanceResponse;
import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.service.gas_station.GasStationFuelService;
import com.qgasosa.backend.service.gas_station.GasStationService;
import com.qgasosa.backend.util.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(Constants.API_BASE_URL + "/gas_station")
public class GasStationApiController {

    private final Logger logger = LogManager.getLogger(GasStationApiController.class);

    @Autowired
    private GasStationService gasStationService;

    @Autowired
    private GasStationFuelService gasStationFuelService;

    @GetMapping(value = "/closest")
    public ResponseEntity<List<GasStationDistanceResponse>> getClosestGasStation(
            @RequestParam("latitude") String originLatitude,
            @RequestParam("longitude") String originLongitude) throws IOException {
        this.logger.info(String.format("Requesting closest gas stations from %s,%s", originLatitude, originLongitude));

        List<GasStationDistanceResponse> closestGasStations = this.gasStationService.findClosestGasStations(originLatitude, originLongitude);
        return new ResponseEntity<>(closestGasStations, HttpStatus.OK);
    }

    @GetMapping(value = "/better")
    public ResponseEntity<List<GasStationFuelDistanceResponse>> getBetterGasStation(
            @RequestParam("latitude") String originLatitude,
            @RequestParam("longitude") String originLongitude,
            @RequestParam("consumption")Double consumption) throws IOException {
        this.logger.info(String.format("Requesting the best gas stations from %s %s %s", originLatitude,
                originLongitude, consumption));

        List<GasStationFuelDistanceResponse> betterGasStations = this.gasStationFuelService.findBetterGasStations(originLatitude, originLongitude, consumption);
        return new ResponseEntity<>(betterGasStations, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<GasStation> createGasStation(@RequestBody GasStationDTO gasStationDTO) {
        this.logger.info(String.format("Creating gas station with payload %s", gasStationDTO));
        GasStation gasStation = gasStationService.addGasStation(gasStationDTO);

        return new ResponseEntity<>(gasStation, HttpStatus.CREATED);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<GasStation>> findAllGasStation() {
        List<GasStation> gasStations = gasStationService.findAllGasStations();

        return new ResponseEntity<>(gasStations, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateGasStation(@RequestParam Long gasStationId, @RequestBody GasStationDTO gasStationDTO) {
        gasStationService.updateGasStation(gasStationId, gasStationDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
