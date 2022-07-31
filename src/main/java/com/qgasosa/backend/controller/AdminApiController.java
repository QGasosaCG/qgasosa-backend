package com.qgasosa.backend.controller;


import com.qgasosa.backend.dto.BatchGasStationFuelDTO;
import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.dto.GasStationFuelDTO;
import com.qgasosa.backend.dto.XlsDTO;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.service.admin.AdminService;
import com.qgasosa.backend.util.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(Constants.API_BASE_URL + "/admin")
public class AdminApiController {

    private final Logger logger = LogManager.getLogger(AdminApiController.class);

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/gas_station/{id}/fuel", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateGasStationFuelPrice(@PathVariable("id") Long gasStationId, @RequestBody BatchGasStationFuelDTO gasStationFuelDTO) {
        this.adminService.updateGasStationFuelPrice(gasStationId, gasStationFuelDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/gas_station")
    public ResponseEntity<GasStation> createGasStation(@RequestBody GasStationDTO gasStationDTO) {
        this.logger.info(String.format("Creating gas station with payload %s", gasStationDTO));
        GasStation gasStation = this.adminService.createGasStation(gasStationDTO);

        return new ResponseEntity<>(gasStation, HttpStatus.CREATED);
    }

    @PutMapping("/gas_station/{gasStationId}")
    public ResponseEntity<Void> updateGasStation(@PathVariable Long gasStationId, @RequestBody GasStationDTO gasStationDTO) {
        this.logger.info(String.format("Updating gas station %d with payload %s", gasStationId, gasStationDTO));

        this.adminService.updateGasStation(gasStationId, gasStationDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/gas_station/xls")
    public ResponseEntity<Void> updateGasStations(@RequestBody XlsDTO xlsDTO) {
        logger.info("Updating gas station fuels via .xls file");

        this.adminService.updateGasStationFuelByXLS(xlsDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/invoice/{id}")
    public ResponseEntity<Void> validateInvoice(@PathVariable("id") Long gasStationId, @RequestBody GasStationFuelDTO gasStationFuelDTO) {
        this.adminService.updateGasStationFuelPrice(gasStationId, gasStationFuelDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
