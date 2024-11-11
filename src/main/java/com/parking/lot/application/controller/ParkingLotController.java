package com.parking.lot.application.controller;

import com.parking.lot.application.dto.CreateParkingLotRequestDTO;
import com.parking.lot.application.model.ParkingLot;
import com.parking.lot.application.service.ParkingLotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/parking-lot")
@AllArgsConstructor
public class ParkingLotController {
    private ParkingLotService parkingLotService;
    @PostMapping()
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequestDTO requestDto) {
        validate(requestDto);
        ParkingLot parkingLot = transform(requestDto);
        return parkingLotService.create(parkingLot);
    }

    @GetMapping("/{id}")
    public ParkingLot getParkingLot(@PathVariable("id") Long id){
        return ParkingLot.builder().id(id).build();
    }

    private void validate(CreateParkingLotRequestDTO requestDto) {
        if(requestDto.getNumberOfFloors()<0){
            throw new RuntimeException("Invalid Number Of Floors.");
        }
    }
    private ParkingLot transform(CreateParkingLotRequestDTO requestDto){
        return requestDto.toParkingLot();
    }
}
