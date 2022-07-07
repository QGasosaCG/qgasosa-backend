package com.qgasosa.backend.controller;

import com.qgasosa.backend.controller.response.ClosestGasStationResponse;
import com.qgasosa.backend.service.gas_station.GasStationService;
import com.qgasosa.backend.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(Constants.API_BASE_URL + "/gas_station")
public class GasStationApiController {
    @Autowired
    private GasStationService gasStationService;

    @RequestMapping(value = "/closest", method = RequestMethod.GET)
    public ResponseEntity<List<ClosestGasStationResponse>> getClosestGasStation(
            @RequestParam("latitude") String originLatitude, @RequestParam("longitude") String originLongitude) throws IOException {
        List<ClosestGasStationResponse> closest = this.gasStationService.getClosestGasStation(originLatitude, originLongitude);
        return new ResponseEntity<>(closest, HttpStatus.OK);
    }
}
