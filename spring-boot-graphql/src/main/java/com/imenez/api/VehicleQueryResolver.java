package com.imenez.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.imenez.entity.Vehicle;
import com.imenez.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {


    private final VehicleService vehicleService;

    public List<Vehicle> getVehicles(String type){

        return vehicleService.getVehicleByTypeLike(type);
    }

    public Optional<Vehicle> getVehicleById(Long id){

        return vehicleService.getVehicleById(id);
    }
}
