package com.system.reservation.reservation.service;

import com.system.reservation.filmshow.model.FilmShow;
import com.system.reservation.reservation.model.Reservation;
import com.system.reservation.seatticket.model.SeatTicket;
import com.system.reservation.ticket.model.Ticket;
import com.system.reservation.reservation.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    @Transactional
    public Reservation addReservation(Reservation reservation){
        FilmShow filmShow = reservation.getFilmShow();
        Set<Reservation> reservations = filmShow.getReservations();
        Set<Set<SeatTicket>> seatNumbers = new HashSet<>();
        for(Reservation reservation1 : reservations) {
            for (Ticket ticket : reservation1.getTicket()) {
                seatNumbers.add(ticket.getSeatTickets());
            }
        }

        for (Ticket ticket : reservation.getTicket()) {
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









}
