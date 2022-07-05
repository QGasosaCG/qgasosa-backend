package com.qgasosa.backend.controller;


import com.qgasosa.backend.dto.GasStationFuelDTO;
import com.qgasosa.backend.model.GasStationFuel;
import com.qgasosa.backend.service.admin.AdminService;
import com.qgasosa.backend.service.gas_station.GasStationFuelService;
import com.qgasosa.backend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(Constants.API_PREFFIX + "/admin")
public class AdminApiController {

    @Autowired
    AdminService adminService;

    @Autowired
    GasStationFuelService gasStationFuelService;

    @RequestMapping(value = "/gas_station/{id}/fuel", method = RequestMethod.PUT)
    public ResponseEntity<?> updateGasStationPrice(@PathVariable("id") Long id, @RequestBody GasStationFuelDTO gasStationFuelDTO) {

       // Optional<GasStationFuel> gasStationFuelOp =  gasStationFuelService;

        return null;
    }

}
