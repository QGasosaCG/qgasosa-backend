package com.qgasosa.backend.controller;

import com.qgasosa.backend.dto.XlsDTO;
import com.qgasosa.backend.service.gas_station.GasStationFuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xls")
public class XlsApiController {

    @Autowired
    GasStationFuelService gasStationFuelService;

    @PutMapping("/update")
    public ResponseEntity<Void> updateGasStations(@RequestBody XlsDTO xlsDTO) {
        this.gasStationFuelService.updateGasStationFuelByXLS(xlsDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
