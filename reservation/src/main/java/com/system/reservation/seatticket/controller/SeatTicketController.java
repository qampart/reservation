package com.system.reservation.seatticket.controller;

import com.system.reservation.ticket.enums.TicketStatus;
import com.system.reservation.seatticket.service.SeatTicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/seatToTicket")
public class SeatTicketController {

    private final SeatTicketService seatTicketService;

    @GetMapping("/{id}")
    public Enum<TicketStatus> checkIfValid(@RequestParam Long id){
        return seatTicketService.checkIfValid(id);
    }

    @PostMapping("/{id}")
    public TicketStatus giveInvalidStatus(@RequestParam Long id){
        return seatTicketService.giveInvalidStatus(id);
    }

}
