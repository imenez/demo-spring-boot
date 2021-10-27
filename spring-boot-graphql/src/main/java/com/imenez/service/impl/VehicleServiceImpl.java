package com.imenez.service.impl;

import com.imenez.dto.VehicleDto;
import com.imenez.entity.Vehicle;
import com.imenez.repository.VehicleRepository;
import com.imenez.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
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


    @Override
    public Vehicle createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(vehicleDto.getType());
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setModelCode(vehicleDto.getModelCode());
        vehicle.setLaunchDate(new Date());

        vehicleRepository.save(vehicle);

        return vehicle;
    }
}
