package com.qgasosa.backend.service.admin;

import com.qgasosa.backend.dto.GasStationFuelDTO;
import com.qgasosa.backend.model.Admin;
import com.qgasosa.backend.repository.AdminRepository;
import com.qgasosa.backend.service.gas_station.GasStationFuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private GasStationFuelService gasStationFuelService;

    @Override
    public Admin findAdminByUsername(String username) { return this.adminRepository.findByUsername(username).orElse(null); }

    @Override
    public Admin findAdminById(Long id) { return this.adminRepository.findById(id).orElse(null); }

    @Override
    public void updateGasStationPrice(Long gasStationId, GasStationFuelDTO gasStationFuelDTO) {
        this.gasStationFuelService.updateGasStationFuelPrice(gasStationId, gasStationFuelDTO);
    }

}
