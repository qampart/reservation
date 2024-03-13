package com.system.reservation.seatticket.model;

import com.system.reservation.seat.model.Seat;
import com.system.reservation.ticket.model.Ticket;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "seat_tickets")
public class SeatTicket {

    @Id
    @SequenceGenerator(name = "seat_tickets_sequence", sequenceName = "seat_tickets_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seat_tickets_sequence")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", nullable = false)
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id", nullable = false)
    private Seat seat;
}
