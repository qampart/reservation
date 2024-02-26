package com.system.reservation.reservation.service;

import com.system.reservation.reservation.model.Seat;
import com.system.reservation.reservation.model.SeatReservation;
import com.system.reservation.reservation.repository.SeatReservationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatReservationService {

    private final SeatReservationRepository seatReservationRepository;

    @Autowired
    public SeatReservationService(SeatReservationRepository seatReservationRepository) {
        this.seatReservationRepository = seatReservationRepository;
    }
    public List<SeatReservation> getAllSitReservations() {
        return seatReservationRepository.findAll();
    }

    public void deleteSeatReservationById(Long id) {
        boolean exists = seatReservationRepository.existsById(id);
        if (!exists){
            throw new RuntimeException("Seat reservation with " + id + " does not exists");
        }
        seatReservationRepository.deleteById(id);
    }

    @Transactional
    public SeatReservation addNewSeatReservation(SeatReservation seatReservation){
        return seatReservationRepository.save(seatReservation);
    }




}
