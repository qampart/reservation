package com.system.reservation.movie.model;

import com.system.reservation.reservation.model.Reservation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "film_shows")
public class FilmShow {

    @Id
    @SequenceGenerator(name = "film_show_sequence", sequenceName = "film_show_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_show_sequence")
    private Long id;
    private LocalDateTime filmLocalDateTime;
    @OneToMany(targetEntity = Reservation.class, mappedBy = "filmShow", cascade = CascadeType.REMOVE)
    private Set<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", nullable = false)
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "cinema_hall_id", referencedColumnName = "id", nullable = false)
    private CinemaHall cinemaHall;
}
