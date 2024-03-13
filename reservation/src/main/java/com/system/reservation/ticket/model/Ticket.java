package com.system.reservation.ticket.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.system.reservation.ticket.enums.TicketStatus;
import com.system.reservation.ticket.enums.TicketType;
import com.system.reservation.reservation.model.Reservation;
import com.system.reservation.seatticket.model.SeatTicket;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @SequenceGenerator(name = "ticket_sequence", sequenceName = "ticket_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_sequence")
    private Long id;
    @Enumerated(EnumType.STRING)
    private TicketType type;
    @Enumerated(EnumType.STRING)
    private TicketStatus status;
    @OneToMany @JoinColumn(name = "seat_ticket_id", referencedColumnName = "id", nullable = false)
    private List<SeatTicket> seatTickets;
    @ManyToOne @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private Reservation reservation;
}
