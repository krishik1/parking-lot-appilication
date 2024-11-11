package com.parking.lot.application.dto;

import com.parking.lot.application.model.VehicleType;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class CreateTicketRequestDTO {
    private Long parkingLotId;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Long entryGateId;
    private Long issuerId;
}
