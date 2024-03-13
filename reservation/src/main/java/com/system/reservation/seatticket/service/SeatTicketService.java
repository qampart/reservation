package com.system.reservation.seatticket.service;

import com.system.reservation.ticket.enums.TicketStatus;
import com.system.reservation.seatticket.model.SeatTicket;
import com.system.reservation.seatticket.repository.SeatTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatTicketService {

    private final SeatTicketRepository seatTicketRepository;

    @Autowired
    public SeatTicketService(SeatTicketRepository seatTicketRepository) {
        this.seatTicketRepository = seatTicketRepository;
    }
    public List<SeatTicket> getAllSitReservations() {
        return seatTicketRepository.findAll();
    }

    public void deleteSeatReservationById(Long id) {
        boolean exists = seatTicketRepository.existsById(id);
        if (!exists){
            throw new RuntimeException("Seat reservation with " + id + " does not exists");
        }
        seatTicketRepository.deleteById(id);
    }

    public SeatTicket addNewSeatReservation(SeatTicket seatTicket){
        return seatTicketRepository.save(seatTicket);
    }

}
