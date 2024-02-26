package com.system.reservation.reservation.controller;

import com.system.reservation.reservation.model.Reservation;
import com.system.reservation.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAllReservations();
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation){
         return reservationService.addReservation(reservation);
    }

    @GetMapping("/user/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id){
        return reservationService.getById(id);
    }

    @DeleteMapping(path = {"/{id}"})
    public void deleteReservationById(@PathVariable Long id){
         reservationService.deleteByid(id);
    }

}
