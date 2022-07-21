package com.qgasosa.backend.service.gas_station;


import com.qgasosa.backend.dto.GasStationFuelDTO;
import com.qgasosa.backend.dto.XlsDTO;
import com.qgasosa.backend.dto.XlsUnitDTO;
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
        Collection<GasStationFuel> gasStationFuels = this.gasStationFuelRepository.findByGasStation(gasStation);

        GasStationFuel updatedGasStation = null;
        for (GasStationFuel gasStationFuel : gasStationFuels) {
            if (gasStationFuel.getFuel().equals(fuel)) {
                gasStationFuel.setPrice(price);
                updatedGasStation = gasStationFuel;
                break;
            }
        }

        return updatedGasStation;
    }

    @Override
    @Transactional
    public void updateGasStationFuelByXLS(XlsDTO xls) {
        for (XlsUnitDTO xlsUnitDTO : xls.payload()) {
            try {
                this.updateGasStationFuel(xlsUnitDTO);
                logger.info(String.format("Updated gas station %s fuel %s price to %.4f", xlsUnitDTO.gasStationName(), xlsUnitDTO.fuelName(), xlsUnitDTO.newPrice()));
            } catch (GasStationNotFoundException | FuelNotFoundException e) {
                logger.error(e.getMessage());
                continue;
            }
        }
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
