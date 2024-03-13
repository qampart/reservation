package com.system.reservation.reservation.dto.mapper;

import com.system.reservation.reservation.dto.ReservationDto;
import com.system.reservation.reservation.model.Reservation;

public class ReservationDtoMapper {

    public static Reservation mapToJpa(ReservationDto reservationDto) {
        return Reservation.builder()

                .build();
    }
}
