package com.qgasosa.backend.exception.fuel;

import com.qgasosa.backend.exception.common.NotFoundException;

public class FuelNotFoundException extends NotFoundException {

    private static final String FUEL_WITH_NAME_NOT_FOUND = "Fuel with name '%s' not found.";

    private static final String FUEL_WITH_ID_NOT_FOUND = "Fuel with id '%d' not found.";

    public FuelNotFoundException(String name) {
        super(String.format(FUEL_WITH_NAME_NOT_FOUND, name));
    }

    public FuelNotFoundException(Long id) {
        super(String.format(FUEL_WITH_ID_NOT_FOUND, id));
    }
}
