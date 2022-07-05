package com.qgasosa.backend.exception.gas_station;

import com.qgasosa.backend.exception.common.NotFoundException;

public class GasStationNotFoundException extends NotFoundException {

    private static final String GAS_STATION_WITH_NAME_NOT_FOUND = "Gas station with name '%s' not found.";

    private static final String GAS_STATION_WITH_ID_NOT_FOUND = "Gas station with id '%d' not found.";

    public GasStationNotFoundException(String name) {
        super(String.format(GAS_STATION_WITH_NAME_NOT_FOUND, name));
    }

    public GasStationNotFoundException(Long id) {
        super(String.format(GAS_STATION_WITH_ID_NOT_FOUND, id));
    }
}
