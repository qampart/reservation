package com.system.reservation.seat.model;

import com.system.reservation.seatticket.model.SeatTicket;
import jakarta.persistence.*;
import lombok.*;

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
    @OneToMany(targetEntity = SeatTicket.class, mappedBy = "seat", cascade = CascadeType.REMOVE)
    private Set<SeatTicket> seatTickets;
//    @ManyToOne @JoinColumn(name = "reservation_id", referencedColumnName = "id", nullable = false)
//    private Reservation reservation;

}
