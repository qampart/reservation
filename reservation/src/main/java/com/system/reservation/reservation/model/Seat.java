package com.system.reservation.reservation.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @SequenceGenerator(name = "seat_sequence", sequenceName = "seat_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seat_sequence")
    private Long id;
    private int seatNumber;
    @OneToMany(targetEntity = SeatReservation.class, mappedBy = "seat", cascade = CascadeType.REMOVE)
    private Set<SeatReservation> seatReservations;
    @OneToMany(targetEntity = Ticket.class, mappedBy = "seat", cascade = CascadeType.REMOVE)
    private Set<Ticket> ticket;

}
