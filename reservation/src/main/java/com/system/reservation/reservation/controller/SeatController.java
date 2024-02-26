package com.system.reservation.reservation.controller;

import com.system.reservation.reservation.model.Seat;
import com.system.reservation.reservation.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("seats")
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getAllSitNumbers(){
        return seatService.getAllSitNumbers();
    }

    @GetMapping("{id}")
    public Optional<Seat> getSitNumberbyId(@RequestParam Long id){
        return seatService.getSitNumber(id);
    }

    @DeleteMapping("{id}")
    public void deleteSeatNumberById(Long id){
        seatService.deleteSeatNumberById(id);
    }

    @PostMapping
    public Seat addNewSeat(@RequestBody Seat seat){
        return seatService.addNewSeat(seat);
    }


}
