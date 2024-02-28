package com.system.reservation.seat.controller;

import com.system.reservation.seat.model.Seat;
import com.system.reservation.seat.service.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    @GetMapping
    public List<Seat> getAllSitNumbers(){
        return seatService.getAllSitNumbers();
    }

    @GetMapping("/{id}")
    public Optional<Seat> getSitNumberbyId(@RequestParam Long id){
        return seatService.getSitNumber(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSeatNumberById(Long id){
        seatService.deleteSeatNumberById(id);
    }

    @PostMapping
    public Seat addNewSeat(@RequestBody Seat seat){
        return seatService.addNewSeat(seat);
    }


}
