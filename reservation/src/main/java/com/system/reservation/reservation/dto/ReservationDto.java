package com.system.reservation.reservation.dto;

import com.system.reservation.filmshow.model.FilmShow;
import com.system.reservation.reservation.enums.ReservationStatus;

import java.time.LocalDate;

public class ReservationDto {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private ReservationStatus reservationStatus;
    private FilmShow filmShow;
}
