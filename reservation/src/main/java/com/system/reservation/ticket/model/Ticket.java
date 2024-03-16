package com.system.reservation.ticket.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.system.reservation.reservation.model.Reservation;
import com.system.reservation.seatticket.model.SeatTicket;
import com.system.reservation.ticket.enums.TicketStatus;
import com.system.reservation.ticket.enums.TicketType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @SequenceGenerator(name = "ticket_sequence", sequenceName = "ticket_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_sequence")
    private Long id;
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    @ManyToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    @JsonIgnore
    private Reservation reservation;
}
