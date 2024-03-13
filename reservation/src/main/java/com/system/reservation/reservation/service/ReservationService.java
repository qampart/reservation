package com.system.reservation.reservation.service;

import com.system.reservation.filmshow.model.FilmShow;
import com.system.reservation.reservation.enums.ReservationStatus;
import com.system.reservation.reservation.model.Reservation;
import com.system.reservation.seatticket.model.SeatTicket;
import com.system.reservation.ticket.model.Ticket;
import com.system.reservation.reservation.repository.ReservationRepository;
import com.system.reservation.ticket.repository.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final TicketRepository ticketRepository;

    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    @Transactional
    public Reservation addReservation(Reservation reservation){
        FilmShow filmShow = reservation.getFilmShow();
        List<Reservation> reservations = filmShow.getReservations();
        Set<SeatTicket> seatNumbers = new HashSet<>();


//        for(Reservation reservation1 : reservations) {
//            for (Ticket ticket : reservation1.getTickest()) {
//                seatNumbers.add(ticket.getSeatTickets());
//            }
//        }
        // TODO: 13.03.2024 sprawdzic czy wolne miejsca

        for (Ticket ticket : reservation.getTickets()) {
            if (seatNumbers.contains(ticket.getSeatTickets())) {
                throw new RuntimeException("Seat not available");
            }
        }

        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> getById(Long id) {
        return reservationRepository.findById(id);
    }

    public void deleteByid(Long id) {
        boolean exists = reservationRepository.existsById(id);
        if (!exists){
            throw new RuntimeException("Reservation with " + id + " does not exists");
        }
        reservationRepository.deleteById(id);
    }

    public ReservationStatus checkReservationStatus(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Reservation with id " + id + " not found"));
        return reservation.getReservationStatus();
    }


}
