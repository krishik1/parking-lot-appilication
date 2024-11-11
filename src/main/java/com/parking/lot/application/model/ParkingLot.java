package com.parking.lot.application.model;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
@Getter
@SuperBuilder
public class ParkingLot extends BaseModel{
    private String name;
    private String address;
    @Builder.Default
    private List<ParkingFloor> floors = new ArrayList<>();
    @Builder.Default
    private List<EntryGate> entryGates = new ArrayList<>();
    @Builder.Default
    private List<ExitGate> exitGates = new ArrayList<>();
}
