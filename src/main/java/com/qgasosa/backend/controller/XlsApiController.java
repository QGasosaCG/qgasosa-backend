package com.qgasosa.backend.controller;

import com.qgasosa.backend.dto.XlsDTO;
import com.qgasosa.backend.service.gas_station.GasStationFuelService;
import com.qgasosa.backend.util.Constants;
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
@RequestMapping(Constants.API_BASE_URL + "/xls")
public class XlsApiController {

    private final static Logger logger = LogManager.getLogger(XlsApiController.class);

    @Autowired
    private GasStationFuelService gasStationFuelService;

    @PutMapping("/update")
    public ResponseEntity<Void> updateGasStations(@RequestBody XlsDTO xlsDTO) {
        logger.info("Updating gas station fuels via .xls file");

        this.gasStationFuelService.updateGasStationFuelByXLS(xlsDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
