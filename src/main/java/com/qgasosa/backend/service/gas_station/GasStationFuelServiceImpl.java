package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.dto.GasStationFuelDTO;
import com.qgasosa.backend.dto.XlsDTO;
import com.qgasosa.backend.dto.XlsUnitDTO;
import com.qgasosa.backend.model.Fuel;
import com.qgasosa.backend.model.GasStation;
import com.qgasosa.backend.model.GasStationFuel;
import com.qgasosa.backend.repository.GasStationFuelRepository;
import com.qgasosa.backend.service.fuel.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GasStationFuelServiceImpl implements GasStationFuelService {

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
        GasStationFuel gasStationFuel = this.gasStationFuelRepository.findByGasStation(gasStation).orElse(null);

        if (gasStationFuel != null && gasStationFuel.getFuel().equals(fuel)) {
            gasStationFuel.setPrice(price);
        } else if (gasStationFuel == null && gasStation != null && fuel != null) {
            gasStationFuel = new GasStationFuel(gasStation, fuel, price);
        }

        return gasStationFuel;
    }

    @Override
    @Transactional
    public void updateGasStationFuelByXLS(XlsDTO xls) {
        xls.payload().forEach(this::updateGasStationFuel);
    }

    @Override
    public void updateGasStationFuelPrice(Long gasStationId, GasStationFuelDTO gasStationFuelDTO) {

        GasStation gasStation = this.gasStationService.findGasStationById(gasStationId);

        Fuel fuel = this.fuelService.findFuelById(gasStationFuelDTO.fuelId());

        GasStationFuel gasStationFuel = updateGasStationFuel(gasStationFuelDTO.price(), gasStation, fuel);
        this.gasStationFuelRepository.save(gasStationFuel);
    }

}
