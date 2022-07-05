package com.qgasosa.backend.controller;

import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.repository.GasStationRepository;
import com.qgasosa.backend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(Constants.API_BASE_URL + "/gas_station")
public class GasStationApiController {

    @Autowired
    GasStationRepository gasStationRepository;

    @GetMapping("/list")
    public ResponseEntity<Collection<GasStation>> g() {
        return new ResponseEntity<>(gasStationRepository.findAll(), HttpStatus.OK);
    }
}
