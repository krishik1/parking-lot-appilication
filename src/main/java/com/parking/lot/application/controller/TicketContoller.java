package com.parking.lot.application.controller;

import com.parking.lot.application.dto.CreateTicketRequestDTO;
import com.parking.lot.application.model.Ticket;
import com.parking.lot.application.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ticket")
@AllArgsConstructor
public class TicketContoller {
    private TicketService ticketService;
    @PostMapping
    public Ticket createTicket(CreateTicketRequestDTO createTicketRequestDTO){
        return ticketService.createTicket(createTicketRequestDTO);
    }
}
