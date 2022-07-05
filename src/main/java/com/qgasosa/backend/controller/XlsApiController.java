package com.qgasosa.backend.controller;

import com.qgasosa.backend.dto.XlsDTO;
import com.qgasosa.backend.service.gas_station.GasStationFuelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private final static Logger logger = LogManager.getLogger(XlsApiController.class);

    @Autowired
    GasStationFuelService gasStationFuelService;

    @PutMapping("/update")
    public ResponseEntity<Void> updateGasStations(@RequestBody XlsDTO xlsDTO) {
        logger.info("Updating gas station fuels via .xls file");

        this.gasStationFuelService.updateGasStationFuelByXLS(xlsDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
