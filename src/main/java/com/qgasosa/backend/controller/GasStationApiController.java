package com.qgasosa.backend.controller;

import com.qgasosa.backend.controller.response.gas_station.CheapestGasStationResponse;
import com.qgasosa.backend.controller.response.gas_station.ClosestGasStationResponse;
import com.qgasosa.backend.controller.response.BestGasStationResponse;
import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.model.GasStation;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping(Constants.API_BASE_URL + "/gas_station")
public class GasStationApiController {

    private final Logger logger = LogManager.getLogger(GasStationApiController.class);

    @Autowired
    private GasStationService gasStationService;

    @GetMapping("/closest")
    public ResponseEntity<List<ClosestGasStationResponse>> getClosestGasStations(
            @RequestParam("latitude") String originLatitude,
            @RequestParam("longitude") String originLongitude) throws IOException {
        this.logger.info(String.format("Requesting closest gas stations from %s,%s", originLatitude, originLongitude));

        List<ClosestGasStationResponse> closestGasStations = this.gasStationService.findClosestGasStations(originLatitude, originLongitude);
        return new ResponseEntity<>(closestGasStations, HttpStatus.OK);
    }

    @GetMapping("/best")
    public ResponseEntity<List<BestGasStationResponse>> getBestGasStations(
            @RequestParam("latitude") String originLatitude,
            @RequestParam("longitude") String originLongitude,
            @RequestParam("consumption") Double consumption) throws IOException {
        this.logger.info(String.format("Requesting the best gas stations from %s %s with consumption %.2f", originLatitude, originLongitude, consumption));

        List<BestGasStationResponse> betterGasStations = this.gasStationService.findBestGasStations(originLatitude, originLongitude, consumption);
        return new ResponseEntity<>(betterGasStations, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GasStationDTO>> findAllGasStation() {
        this.logger.info("Requesting all gas stations.");

        List<GasStation> gasStations = gasStationService.findAllGasStations();
        List<GasStationDTO> gasStationDTOs = gasStations
                .stream()
                .map(gasStation -> new GasStationDTO(gasStation.getName(), gasStation.getAddress()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(gasStationDTOs, HttpStatus.OK);
    }

    @GetMapping("/cheapest")
    public ResponseEntity<List<CheapestGasStationResponse>> getCheapestGasStations(@RequestParam("fuelName") String fuelName) {
        this.logger.info(String.format("Requesting cheapest gas stations with fuel '%s'", fuelName));

        List<CheapestGasStationResponse> cheapestGasStations = this.gasStationService.findCheapestGasStation(fuelName);
        return new ResponseEntity<>(cheapestGasStations, HttpStatus.OK);
    }
}
