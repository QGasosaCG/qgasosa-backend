package com.qgasosa.backend.controller;

import com.qgasosa.backend.dto.FuelDTO;
import com.qgasosa.backend.service.fuel.FuelService;
import com.qgasosa.backend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(Constants.API_BASE_URL + "/fuel")
public class FuelApiController {

    @Autowired
    private FuelService fuelService;

    @GetMapping
    public ResponseEntity<List<FuelDTO>> findAllFuels() {
        List<FuelDTO> fuels = this.fuelService.findAllFuels();
        return new ResponseEntity<>(fuels, HttpStatus.OK);
    }
}
