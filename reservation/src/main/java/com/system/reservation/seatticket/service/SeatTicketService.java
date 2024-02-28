package com.system.reservation.seatticket.service;

import com.system.reservation.ticket.enums.TicketStatus;
import com.system.reservation.seatticket.model.SeatTicket;
import com.system.reservation.seatticket.repository.SeatTicketRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public SeatTicket addNewSeatReservation(SeatTicket seatTicket){
        return seatTicketRepository.save(seatTicket);
    }

    public Enum<TicketStatus> checkIfValid(Long id) {
        Optional<SeatTicket> optionalTicket = seatTicketRepository.findById(id);

        if (optionalTicket.isPresent()){
            TicketStatus status = optionalTicket.get().getTicket().getStatus();
            if(status.equals(TicketStatus.INVALID)){
                System.out.println("Ticket with " + id + " is invalid");
            }
            return status;
        }
        throw  new RuntimeException("Ticket with ID " + id + " not found");
    }

    public TicketStatus giveInvalidStatus(Long id) {

        Optional<SeatTicket> optionalTicket = seatTicketRepository.findById(id);

        TicketStatus status = optionalTicket.get().getTicket().getStatus();

        if (optionalTicket.isPresent() &&  optionalTicket.get().getTicket().getReservation().getEndDate().isAfter(optionalTicket.get().getTicket().getReservation().getEndDate())){
            optionalTicket.get().getTicket().setStatus(TicketStatus.INVALID);
        }
        else{
            throw new RuntimeException("Ticket with ID " + id + " does not exists");
        }
        return status;

    }

}
