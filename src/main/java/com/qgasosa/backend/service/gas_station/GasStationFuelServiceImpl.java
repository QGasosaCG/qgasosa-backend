package com.qgasosa.backend.service.gas_station;


import com.qgasosa.backend.dto.GasStationFuelDTO;
import com.qgasosa.backend.dto.XlsDTO;
import com.qgasosa.backend.dto.XlsUnitDTO;
import com.qgasosa.backend.exception.common.NotFoundException;
import com.qgasosa.backend.exception.fuel.FuelNotFoundException;
import com.qgasosa.backend.exception.gas_station.GasStationNotFoundException;
import com.qgasosa.backend.model.Fuel;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.model.GasStationFuel;
import com.qgasosa.backend.repository.GasStationFuelRepository;
import com.qgasosa.backend.service.fuel.FuelService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class GasStationFuelServiceImpl implements GasStationFuelService {

    private final Logger logger = LogManager.getLogger(GasStationFuelServiceImpl.class);

    @Autowired
    private GasStationService gasStationService;

    @Autowired
    private GasStationFuelRepository gasStationFuelRepository;

    @Autowired
    private FuelService fuelService;

    private void updateGasStationFuel(XlsUnitDTO xlsUnit) {
        String gasStationName = xlsUnit.gasStationName();
        String fuelName = xlsUnit.fuelName();
        Double price = xlsUnit.newPrice();

        GasStation gasStation = this.gasStationService.findGasStationByName(gasStationName);
        Fuel fuel = this.fuelService.findFuelByName(fuelName);

        GasStationFuel gasStationFuel = updateGasStationFuel(price, gasStation, fuel);
        this.gasStationFuelRepository.save(gasStationFuel);
    }

    private GasStationFuel updateGasStationFuel(Double price, GasStation gasStation, Fuel fuel) {
        GasStationFuel gasStationFuel = this.gasStationFuelRepository.findByGasStationAndFuel(gasStation, fuel).orElse(null);
        if (gasStationFuel == null) {
            gasStationFuel = new GasStationFuel(gasStation, fuel, price);
        } else {
            gasStationFuel.setPrice(price);
        }

        gasStationFuel.setUpdatedAt(new Date());
        return this.gasStationFuelRepository.save(gasStationFuel);
    }

    @Override
    @Transactional
    public void updateGasStationFuelByXLS(XlsDTO xls) {
        for (XlsUnitDTO xlsUnitDTO : xls.payload()) {
            try {
                this.updateGasStationFuel(xlsUnitDTO);
                logger.info(String.format("Updated gas station %s fuel %s price to %.4f", xlsUnitDTO.gasStationName(), xlsUnitDTO.fuelName(), xlsUnitDTO.newPrice()));
            } catch (NotFoundException e) {
                logger.error(e.getMessage());
                if (e instanceof FuelNotFoundException) {
                    this.createFuelAndRetry(xlsUnitDTO);
                } else if (e instanceof GasStationNotFoundException) {
                    this.createGasStationAndRetry(xlsUnitDTO);
                }
            }
        }
    }

    private void createGasStationAndRetry(XlsUnitDTO xlsUnitDTO) {
        logger.info(String.format("Creating Gas Station '%s' - '%s' and retrying", xlsUnitDTO.gasStationName(), xlsUnitDTO.gasStationStreet()));

        this.gasStationService.createGasStation(xlsUnitDTO.gasStationName(), xlsUnitDTO.gasStationStreet(), xlsUnitDTO.latitude(), xlsUnitDTO.longitude());
        this.updateGasStationFuel(xlsUnitDTO);
    }

    private void createFuelAndRetry(XlsUnitDTO xlsUnitDTO) {
        logger.info(String.format("Creating Fuel '%s' and retrying", xlsUnitDTO.fuelName()));

        Fuel fuel = new Fuel(xlsUnitDTO.fuelName());
        this.fuelService.saveFuel(fuel);
        this.updateGasStationFuel(xlsUnitDTO);
    }

    @Override
    public void updateGasStationFuelPrice(Long gasStationId, GasStationFuelDTO gasStationFuelDTO) {
        GasStation gasStation = this.gasStationService.findGasStationById(gasStationId);

        Fuel fuel = this.fuelService.findFuelById(gasStationFuelDTO.fuelId());

        GasStationFuel gasStationFuel = updateGasStationFuel(gasStationFuelDTO.price(), gasStation, fuel);
        this.gasStationFuelRepository.save(gasStationFuel);
    }

    @Override
    public List<GasStationFuel> findAllGasStations() {
        return this.gasStationFuelRepository.findAll();
    }

    @Override
    public List<GasStationFuel> findAllGasStationsByFuelName(String fuelName) {
        Fuel fuel = this.fuelService.findFuelByName(fuelName);
        return this.gasStationFuelRepository.findByFuel(fuel);
    }

}
