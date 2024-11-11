package com.parking.lot.application.repository;

import com.parking.lot.application.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepository {
    List<Ticket> tickets = new ArrayList<>();
    public Ticket save(Ticket ticket){
        tickets.add(ticket);
        return ticket;
    }
}
