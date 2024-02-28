package com.system.reservation.seat.service;

import com.system.reservation.seat.model.Seat;
import com.system.reservation.seat.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Optional<Seat> getSitNumber(Long id) {
        return seatRepository.findById(id);
    }

    public List<Seat> getAllSitNumbers() {
        return seatRepository.findAll();
    }

    public void deleteSeatNumberById(Long id) {
        boolean exists = seatRepository.existsById(id);
        if (!exists){
            throw new RuntimeException("Seat with " + id + " does not exists");
        }
        seatRepository.deleteById(id);
    }

    public Seat addNewSeat(Seat seat) {
        return seatRepository.save(seat);
    }
}
