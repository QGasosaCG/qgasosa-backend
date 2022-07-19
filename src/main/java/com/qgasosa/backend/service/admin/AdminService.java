package com.qgasosa.backend.service.admin;

import com.qgasosa.backend.dto.GasStationFuelDTO;
import com.qgasosa.backend.model.Admin;
import com.qgasosa.backend.model.GasStationFuel;

public interface AdminService {

    Admin findAdminByUsername(String username);

    Admin findAdminById(Long id);

    void updateGasStationPrice(Long gasStationId,GasStationFuelDTO gasStationFuelDTO);

    void validateInvoice(Long gasStationId, GasStationFuelDTO gasStationFuelDTO);
}
