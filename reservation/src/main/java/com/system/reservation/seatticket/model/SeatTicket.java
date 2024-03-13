package com.system.reservation.seatticket.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Ticket ticket;
    private Long seatId;
}
