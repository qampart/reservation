package com.system.reservation.cinemahall.controller;

import com.system.reservation.cinemahall.model.CinemaHall;
import com.system.reservation.cinemahall.service.CinemaHalllService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping(path = "/cinemahalls")
public class CinemaHallController {

    private final CinemaHalllService cinemaHalllService;

    @GetMapping()
    public List<CinemaHall> getAllCinemaHalls(){
        return cinemaHalllService.getAllCinemaHalls();
    }

    @GetMapping("/{id}")
    public Optional<CinemaHall> getCinemaHallById(@PathVariable Long id){
        return cinemaHalllService.getCinemaHallById(id);
    }

    @PostMapping
    public CinemaHall addCinemaHall(@RequestBody CinemaHall cinemaHall){
        return cinemaHalllService.addCinemaHall(cinemaHall);
    }





}
