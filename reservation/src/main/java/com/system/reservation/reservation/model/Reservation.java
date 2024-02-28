package com.system.reservation.reservation.model;

import com.system.reservation.filmshow.model.FilmShow;
import com.system.reservation.reservation.enums.ReservationStatus;
import com.system.reservation.ticket.model.Ticket;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @SequenceGenerator(name = "reservation_sequence", sequenceName = "reservation_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_sequence")
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
//    @OneToMany(targetEntity = SeatTicket.class, mappedBy = "reservation", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    private Set<SeatTicket> seatTickets;
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;
    @ManyToOne
    @JoinColumn(name = "film_show_id", referencedColumnName = "id", nullable = false)
    private FilmShow filmShow;
    @OneToMany(targetEntity = Ticket.class, mappedBy = "reservation", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Ticket> ticket;
//    @OneToMany(targetEntity = Seat.class, mappedBy = "reservation", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    private Set<Seat> seat;
}
