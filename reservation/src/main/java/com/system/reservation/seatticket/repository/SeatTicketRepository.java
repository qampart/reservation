package com.system.reservation.seatticket.repository;

import com.system.reservation.seatticket.model.SeatTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatTicketRepository extends JpaRepository<SeatTicket, Long> {


}
