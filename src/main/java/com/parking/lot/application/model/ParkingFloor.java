package com.parking.lot.application.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@SuperBuilder
public class ParkingFloor extends BaseModel {
    private Integer floorNumber;
    private List<ParkingSpot> spots = new ArrayList();
    private DisplayBoard displayBoard;
    private PaymentCounter paymentCounter;

}
