package com.system.reservation.cinemahall.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.system.reservation.filmshow.model.FilmShow;
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
@Table(name = "cinema_halls")
public class CinemaHall {

    @Id
    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence")
    private Long id;
    private String name;
    private Integer capacity;
    @OneToMany @JoinColumn(name = "film_show_id", referencedColumnName = "id", nullable = false)
    private List<FilmShow> filmShows;

}
