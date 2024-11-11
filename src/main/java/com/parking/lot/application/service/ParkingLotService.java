package com.parking.lot.application.service;

import com.parking.lot.application.model.ParkingLot;
import com.parking.lot.application.repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingLotService {

    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotService parkingSpotService;


    public ParkingLot create(ParkingLot parkingLot) {
        ParkingLot persistedLot = parkingLotRepository.save(parkingLot);
        parkingSpotService.createParkingSpots(persistedLot);
        return persistedLot;
    }

    public ParkingLot get(Long id) {
        return ParkingLot.builder().build();
    }
}
