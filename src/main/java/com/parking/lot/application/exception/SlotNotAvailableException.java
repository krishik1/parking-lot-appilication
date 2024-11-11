package com.parking.lot.application.exception;

import com.parking.lot.application.model.VehicleType;

public class SlotNotAvailableException extends RuntimeException {
    public SlotNotAvailableException(VehicleType vehicleType) {
        super("Slot not found for vehicle type: "+vehicleType);
    }
}
