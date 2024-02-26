package com.system.reservation.reservation.model;

import com.system.reservation.movie.model.FilmShow;
import com.system.reservation.reservation.enums.Status;
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
    @OneToMany(targetEntity = SeatReservation.class, mappedBy = "reservation", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<SeatReservation> seatReservations;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "film_show_id", referencedColumnName = "id", nullable = false)
    private FilmShow filmShow;
    @OneToMany(targetEntity = Ticket.class, mappedBy = "reservation", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Ticket> ticket;
}
