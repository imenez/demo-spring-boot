package com.imenez.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.imenez.entity.Vehicle;
import com.imenez.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VehicleQueryResolver implements GraphQLQueryResolver {

    @Autowired
    VehicleService vehicleService;

    public List<Vehicle> getVehicle(String type){

        return vehicleService.getVehicleByTypeLike(type);
    }

    public Optional<Vehicle> getVehicleById(Long id){

        return vehicleService.getVehicleById(id);
    }
}
