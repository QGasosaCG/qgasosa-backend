package com.qgasosa.backend.service.gas_station;

import com.qgasosa.backend.dto.XlsDTO;
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

    @Override
    @Transactional
    public void addFuelToGasStation(Long gasStationId, Long fuelId, Double price) {
        GasStation gasStation = gasStationService.findGasStationById(gasStationId);
        Fuel fuel = fuelService.findFuelById(fuelId);

        GasStationFuel gasStationFuel = new GasStationFuel(gasStation, fuel, price);
        this.gasStationFuelRepository.save(gasStationFuel);
    }

    @Override
    @Transactional
    public void updateGasStationFuel(String gasStationName, String fuelName, Double price) {
        GasStation gasStation = gasStationService.findGasStationByName(gasStationName);
        Fuel fuel = fuelService.findFuelByName(fuelName);

        GasStationFuel gasStationFuel = this.gasStationFuelRepository.findByGasStation(gasStation).orElse(null);

        if (gasStationFuel != null && gasStationFuel.getFuel().equals(fuel)) {
            gasStationFuel.setPrice(price);
            this.gasStationFuelRepository.save(gasStationFuel);
        }
    }

    @Override
    @Transactional
    public void updateGasStationFuelByXLS(XlsDTO xls) {
        xls.getPayload().forEach(object -> {
            String gasStationName = object.getGasStationName();
            String fuelName = object.getFuelName();
            Double newPrice = object.getNewPrice();

            this.updateGasStationFuel(gasStationName, fuelName, newPrice);
        });
    }

}
