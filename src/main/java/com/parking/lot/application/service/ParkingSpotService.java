package com.parking.lot.application.service;

import com.parking.lot.application.model.ParkingLot;
import com.parking.lot.application.model.ParkingSpot;
import com.parking.lot.application.model.VehicleType;
import com.parking.lot.application.repository.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingSpotService {
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;
    public ParkingSpot allocateSpot(Long parkingLotId, VehicleType vehicleType){
        return parkingSpotRepository.findOneByVehicleTypeAndStatusAvailable(vehicleType);
    }

    public void createParkingSpots(ParkingLot parkingLot){
        List<ParkingSpot> parkingSpots = parkingLot.getFloors().stream().flatMap(floor->floor.getSpots().stream()).collect(Collectors.toList());
        parkingSpotRepository.saveAll(parkingSpots);
    }
    public ParkingSpot update(ParkingSpot filledSpot) {
        return parkingSpotRepository.update(filledSpot);
    }
    public List<ParkingSpot> getParkingSpots(Long id) {
        return parkingSpotRepository.findAllByParkingLotId(id);
    }

    public ParkingSpot getParkingSpot(Long id) {
        return parkingSpotRepository.findOneById(id);
    }


}
