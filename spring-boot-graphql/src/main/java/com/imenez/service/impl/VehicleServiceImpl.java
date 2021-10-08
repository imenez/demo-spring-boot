package com.imenez.service.impl;

import com.imenez.entity.Vehicle;
import com.imenez.repository.VehicleRepository;
import com.imenez.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;


    @Override
    public List<Vehicle> getVehicleByTypeLike(String type) {
        return vehicleRepository.getByTypeLike(type);
    }

    @Override
    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }
}
