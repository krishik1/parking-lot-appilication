package com.parking.lot.application.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
@Getter
@Setter
@SuperBuilder
public class Ticket extends BaseModel {
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private Long spotId;
    private Long entryGateId;
}
