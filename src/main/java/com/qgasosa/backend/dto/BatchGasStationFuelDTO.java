package com.qgasosa.backend.dto;

import java.util.Collection;

public record BatchGasStationFuelDTO(Collection<UpdateGasStationFuelDTO> payload) {
}
