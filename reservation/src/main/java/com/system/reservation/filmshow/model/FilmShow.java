package com.system.reservation.filmshow.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.system.reservation.cinemahall.model.CinemaHall;
import com.system.reservation.movie.model.Movie;
import com.system.reservation.reservation.model.Reservation;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "film_shows")
public class FilmShow {

    @Id
    @SequenceGenerator(name = "film_show_sequence", sequenceName = "film_show_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_show_sequence")
    private Long id;
    private LocalDateTime filmLocalDateTime;
    @OneToMany
    @JoinColumn(name = "reservation_id", referencedColumnName = "id")
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "cinema_hall_id", referencedColumnName = "id")
    private CinemaHall cinemaHall;

}
