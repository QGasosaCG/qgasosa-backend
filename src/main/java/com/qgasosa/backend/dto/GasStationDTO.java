package com.qgasosa.backend.dto;

import com.qgasosa.backend.model.Address;
import com.qgasosa.backend.model.GasStation;

import java.util.Set;

public record GasStationDTO(long id, String name, Address address, Set<GasStation> fuels) {
}