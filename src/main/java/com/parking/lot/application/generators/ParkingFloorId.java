package com.parking.lot.application.generators;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingFloorId {
    private static AtomicLong idCounter = new AtomicLong();
    public static Long nextFloorId() {
        return idCounter.getAndIncrement();
    }
}
