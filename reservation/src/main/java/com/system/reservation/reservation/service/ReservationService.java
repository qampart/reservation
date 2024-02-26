package com.system.reservation.reservation.service;

import com.system.reservation.movie.model.FilmShow;
import com.system.reservation.reservation.model.Reservation;
import com.system.reservation.reservation.model.SeatReservation;
import com.system.reservation.reservation.repository.ReservationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        FilmShow filmShow = reservation.getFilmShow();  // pobieram dane o seansie filmowym tzn data godzina, tytuł filmu itd., czyli najpierw dla mojej rezerwacji pobieram dane o seansie filmowym na ktory chce dokonac rezerwacji
        Set<Reservation> reservations = filmShow.getReservations();  // pobieram info o rezerwacjach, które są zrobione na ten seans
        Set<Integer> seatNumbers = new HashSet<>();
        for(Reservation reservation1 : reservations) {
            for (SeatReservation seatReservation : reservation1.getSeatReservations()) {
                seatNumbers.add(seatReservation.getSeat().getSeatNumber());
            }
        }

        for (SeatReservation seatReservation : reservation.getSeatReservations()) {
            if (seatNumbers.contains(seatReservation.getSeat().getSeatNumber())) {
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
