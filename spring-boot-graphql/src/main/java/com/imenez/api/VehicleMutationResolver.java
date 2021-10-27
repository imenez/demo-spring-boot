package com.imenez.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.imenez.dto.VehicleDto;
import com.imenez.entity.Vehicle;
import com.imenez.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class VehicleMutationResolver implements GraphQLMutationResolver {


    @Autowired
    private VehicleService vehicleService;



    public Vehicle createVehicle(VehicleDto vehicleDto){

        return vehicleService.createVehicle(vehicleDto);

    }


}
