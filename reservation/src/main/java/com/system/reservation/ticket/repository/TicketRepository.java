package com.system.reservation.ticket.repository;

import com.system.reservation.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

//    List<Ticket> findAllByReservationIdIn(List<Long> ids);
}
