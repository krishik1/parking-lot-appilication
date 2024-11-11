package com.parking.lot.application.generators;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingLotId {
    private static AtomicLong idCounter = new AtomicLong();

    public static Long nextId() {
        return idCounter.getAndIncrement();
    }
}
