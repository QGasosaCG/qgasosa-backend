package com.qgasosa.backend.exception.gas_station;

import com.qgasosa.backend.exception.common.ConflictException;

public class GasStationAlreadyExistsException extends ConflictException {

    private static final String GAS_STATION_WITH_NAME_ALREADY_EXISTS = "Gas station with name '%s' already exists.";

    public GasStationAlreadyExistsException(String name) {
        super(String.format(GAS_STATION_WITH_NAME_ALREADY_EXISTS, name));
    }
}
