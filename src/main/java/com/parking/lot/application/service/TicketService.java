package com.parking.lot.application.service;

import com.parking.lot.application.dto.CreateTicketRequestDTO;
import com.parking.lot.application.exception.SlotNotAvailableException;
import com.parking.lot.application.model.ParkingSpot;
import com.parking.lot.application.model.SpotStatus;
import com.parking.lot.application.model.Ticket;
import com.parking.lot.application.model.Vehicle;
import com.parking.lot.application.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@AllArgsConstructor
@Service
public class TicketService {
    private ParkingSpotService parkingSpotService;
    private VehicleService vehicleService;
    private TicketRepository ticketRepository;

    public Ticket createTicket(CreateTicketRequestDTO createTicketRequestDTO){
        //check if the spot is available
        //Allocate a spot
        //if null,throw an exception
        ParkingSpot parkingSpot = parkingSpotService.allocateSpot(createTicketRequestDTO.getParkingLotId(),createTicketRequestDTO.getVehicleType());
        if(parkingSpot == null){
            throw new SlotNotAvailableException(createTicketRequestDTO.getVehicleType());
        }

        //update the spot - filled
        //save it in db.
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);
        ParkingSpot updatedSpot = parkingSpotService.update(parkingSpot);
        //vehicle -fetch or create
        //if vehicle is present use that
        //else create new one
        Vehicle vehicle = vehicleService.createVehicle(createTicketRequestDTO.getVehicleNumber(),createTicketRequestDTO.getVehicleType());


        //create a ticket and save it
        Ticket ticket = Ticket.builder().entryTime(LocalDateTime.now()).spotId(updatedSpot.getId())
                .vehicle(vehicle).entryGateId(createTicketRequestDTO.getEntryGateId()).build();

        return ticketRepository.save(ticket);
    }
}
