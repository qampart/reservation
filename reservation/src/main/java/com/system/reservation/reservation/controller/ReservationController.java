package com.system.reservation.reservation.controller;

import com.system.reservation.reservation.enums.ReservationStatus;
import com.system.reservation.reservation.model.Reservation;
import com.system.reservation.reservation.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping()
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

    @DeleteMapping({"/{id}"})
    public void deleteReservationById(@PathVariable Long id){
         reservationService.deleteByid(id);
    }

    @PostMapping("/{id}")
    public ReservationStatus checkReservationStatus(@PathVariable Long id){
        return reservationService.checkReservationStatus(id);
    }


}
