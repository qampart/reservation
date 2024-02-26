package com.system.reservation.reservation.repository;

import com.system.reservation.reservation.model.SeatReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatReservationRepository extends JpaRepository<SeatReservation, Long> {


}
