package com.qgasosa.backend.service.admin;

import com.qgasosa.backend.dto.BatchGasStationFuelDTO;
import com.qgasosa.backend.dto.GasStationDTO;
import com.qgasosa.backend.dto.UpdateGasStationFuelDTO;
import com.qgasosa.backend.dto.XlsDTO;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.service.gas_station.GasStationFuelService;
import com.qgasosa.backend.service.gas_station.GasStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private GasStationFuelService gasStationFuelService;

    @Autowired
    private GasStationService gasStationService;

    @Override
    @Transactional
    public GasStation createGasStation(GasStationDTO gasStationDTO) {
        return this.gasStationService.createGasStation(gasStationDTO);
    }

    @Override
    @Transactional
    public void updateGasStationFuelPrice(Long gasStationId, BatchGasStationFuelDTO gasStationFuelDTO) {
        gasStationFuelDTO
                .payload()
                .forEach(gasStationFuel -> this.gasStationFuelService.updateGasStationFuelPrice(gasStationId, gasStationFuel));
    }

    @Override
    @Transactional
    public void updateGasStationFuelPrice(Long gasStationId, UpdateGasStationFuelDTO gasStationFuelDTO) {
        this.gasStationFuelService.updateGasStationFuelPrice(gasStationId, gasStationFuelDTO);
    }

    @Override
    @Transactional
    public void updateGasStation(Long gasStationId, GasStationDTO gasStationDTO) {
        this.gasStationService.updateGasStation(gasStationId, gasStationDTO);
    }

    @Override
    @Transactional
    public void updateGasStationFuelByXLS(XlsDTO xlsDTO) {
        this.gasStationFuelService.updateGasStationFuelByXLS(xlsDTO);
    }

}
