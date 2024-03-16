package com.system.reservation.reservation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.system.reservation.filmshow.model.FilmShow;
import com.system.reservation.reservation.enums.ReservationStatus;
import com.system.reservation.ticket.model.Ticket;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "film_show_id")
    private FilmShow filmShow;
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
