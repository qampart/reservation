package com.system.reservation.ticket.controller;


import com.system.reservation.ticket.enums.TicketStatus;
import com.system.reservation.ticket.model.Ticket;
import com.system.reservation.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log
@RequestMapping(path = "/tickets")
public class TicketController {


    private final TicketService ticketService;

    @GetMapping
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public boolean checkIfValid(@PathVariable Long id){
        return ticketService.checkIfValid(id);
    }

    @PostMapping
    public Ticket addNewTicket(@RequestBody Ticket ticket){
        return ticketService.addNewTicket(ticket);
    }

    @PostMapping("/{id}")
    public TicketStatus giveInvalidStatus(@PathVariable Long id){
        return ticketService.giveInvalidStatus(id);
    }


//    @GetMapping("/logs")
//    public void getLogs() {
//        Ticket ticket = new Ticket();
//        ticket.setId(1L);
//        log.info(".getLogs for ticker invoked with id - " + ticket.getId());
//        System.out.println(".getLogs for ticker invoked with id - " + ticket.getId());
//    }
}
