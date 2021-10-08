package com.imenez.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.imenez.dto.VehicleDto;
import com.imenez.entity.Vehicle;
import com.imenez.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Component
public class VehicleMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private VehicleRepository vehicleRepository;


    @Transactional
    public Vehicle craeteVehicle(VehicleDto vehicleDto){

        Vehicle vehicle = new Vehicle();
        vehicle.setType(vehicleDto.getType());
        vehicle.setModelCode(vehicleDto.getModelCode());
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setLaunchDate(new Date());

        return vehicleRepository.save(vehicle);

    }


}
