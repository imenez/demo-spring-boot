package com.imenez.service;


import com.imenez.dto.VehicleDto;
import com.imenez.entity.Vehicle;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


public interface VehicleService {


    List<Vehicle> getVehicleByTypeLike(String type);

    Optional<Vehicle> getVehicleById(Long id);

    Vehicle createVehicle(VehicleDto vehicleDto);
}
