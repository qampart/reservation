package com.system.reservation.ticket.service;

import com.system.reservation.ticket.enums.TicketStatus;
import com.system.reservation.ticket.model.Ticket;
import com.system.reservation.ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public Enum<TicketStatus> validateTicket(Long id) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);

        if (optionalTicket.isPresent()) {
            TicketStatus status = optionalTicket.get().getStatus();
            if (status.equals(TicketStatus.INVALID)) {
                System.out.println("Ticket with " + id + " is invalid");
            }
            return status;
        }
        throw  new RuntimeException("Ticket with ID " + id + " not found");
    }



    public TicketStatus giveInvalidStatus(Long id) {

        Optional<Ticket> optionalTicket = ticketRepository.findById(id);

        TicketStatus status = optionalTicket.get().getStatus();

        if (optionalTicket.isPresent() &&  optionalTicket.get().getReservation().getEndDate().isAfter(optionalTicket.get().getReservation().getEndDate())){
            optionalTicket.get().setStatus(TicketStatus.INVALID);
        }
        else{
            throw new RuntimeException("Ticket with ID " + id + " does not exists");
        }
        return status;

    }

    public boolean checkIfValid(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.isPresent() && ticket.get().getStatus().equals(TicketStatus.VALID);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket addNewTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
