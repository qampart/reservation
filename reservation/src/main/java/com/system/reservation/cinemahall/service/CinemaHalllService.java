package com.system.reservation.cinemahall.service;

import com.system.reservation.cinemahall.model.CinemaHall;
import com.system.reservation.cinemahall.repository.CinemaHallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CinemaHalllService {

    private final CinemaHallRepository cinemaHallRepository;

    public List<CinemaHall> getAllCinemaHalls() {
        return cinemaHallRepository.findAll();
    }

    public Optional<CinemaHall> getCinemaHallById(Long id) {
        return cinemaHallRepository.findById(id);
    }

    public CinemaHall addCinemaHall(CinemaHall cinemaHall) {
        return cinemaHallRepository.save(cinemaHall);
    }
}
