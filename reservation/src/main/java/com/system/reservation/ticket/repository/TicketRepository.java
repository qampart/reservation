package com.system.reservation.ticket.repository;

import com.system.reservation.reservation.model.Reservation;
import com.system.reservation.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

//    List<Ticket> findAllByReservationIdIn(List<Long> ids);
}
