package com.parking.lot.application.repository;

import com.parking.lot.application.model.ParkingLot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingLotRepository {
    List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingLot save(ParkingLot parkingLot){
        parkingLots.add(parkingLot);
        return parkingLot;
    }
    public List<ParkingLot> findAll(){
        return parkingLots;
    }
    public ParkingLot findById(Long id){
        return parkingLots.stream().filter(pl -> pl.getId().equals(id)).findFirst().orElse(null);
    }
}
