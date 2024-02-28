package com.system.reservation.cinemahall.model;

import com.system.reservation.filmshow.model.FilmShow;
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
@Table(name = "cinema_halls")
public class CinemaHall {

    @Id
    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence")
    private Long id;
    private String name;
    private Integer capacity;
    @OneToMany(targetEntity = FilmShow.class, mappedBy = "cinemaHall", cascade = CascadeType.REMOVE)
    private Set<FilmShow> filmShows;
}
