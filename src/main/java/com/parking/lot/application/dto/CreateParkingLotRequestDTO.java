package com.parking.lot.application.dto;

import com.parking.lot.application.generators.ParkingFloorId;
import com.parking.lot.application.generators.ParkingLotId;
import com.parking.lot.application.generators.ParkingSpotId;
import com.parking.lot.application.model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class CreateParkingLotRequestDTO {
    private String name;
    private String address;
    private Integer numberOfFloors;
    private Integer numberOfSpotsPerFloor;
    private Integer numberOfEntryGates;
    private Integer numberOfExitGates;

    public ParkingLot toParkingLot(){
        List<ParkingSpot> parkingSpots = Collections.nCopies(numberOfSpotsPerFloor,ParkingSpot.mediumAvailable());
        parkingSpots.forEach(parkingSpot -> parkingSpot.setId(ParkingSpotId.nextId()));
        List<ParkingFloor> parkingFloors = Collections.nCopies(numberOfFloors,ParkingFloor.builder().spots(parkingSpots).paymentCounter(PaymentCounter.builder().build()).build());
        parkingFloors.forEach(parkingFloor -> parkingFloor.setId(ParkingFloorId.nextFloorId()));
        System.out.println(parkingFloors.stream().map(floor ->floor.getSpots().size()));
        return ParkingLot.builder().id(ParkingLotId.nextId()).name(name).address(address).floors(parkingFloors).entryGates(Collections.nCopies(numberOfEntryGates, EntryGate.builder().build()))
                .exitGates(Collections.nCopies(numberOfExitGates, ExitGate.builder().build()))
                .build();

    }
}
