package com.qgasosa.backend.controller;

import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.service.gas_station.GasStationService;
import com.qgasosa.backend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_BASE_URL)
public class GasStationController {

    @Autowired
    GasStationService gasStationService;

    @PostMapping(value = "/gas_station")
    public ResponseEntity<?> createGasStation(@RequestBody GasStationDTO gasStationDTO) {
        GasStation gasStation = gasStationService.addGasStation(gasStationDTO);

        return new ResponseEntity<GasStation>(gasStation, HttpStatus.OK);
    }

    @GetMapping(value = "/gas_station")
    public ResponseEntity<?> findAllGasStation() {
        List<GasStation> gasStations = gasStationService.findAllGasStation();

        return new ResponseEntity<List<GasStation>>(gasStations, HttpStatus.OK);
    }

    @PutMapping(value = "/gas_station")
    public ResponseEntity<?> UpdateGasStation(@RequestBody GasStationDTO gasStationDTO) {
        GasStation gasStation = gasStationService.updateGasStation(gasStationDTO.id(), gasStationDTO);

        return new ResponseEntity<GasStation>(gasStation, HttpStatus.OK);
    }
}
