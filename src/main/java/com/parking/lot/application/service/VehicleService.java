package com.parking.lot.application.service;

import com.parking.lot.application.model.Vehicle;
import com.parking.lot.application.model.VehicleType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleService {
    public Vehicle createVehicle(String vehicleNumber, VehicleType vehicleType){
        return Vehicle.builder().licenseNumber(vehicleNumber).type(vehicleType).build();
    }
}
