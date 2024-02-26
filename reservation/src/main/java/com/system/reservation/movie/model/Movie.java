package com.system.reservation.movie.model;

import com.system.reservation.reservation.model.Reservation;
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
@Table(name = "movies")
public class Movie {

    @Id
    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_sequence")
    private Long id;
    private String name;
    private int length;
    @OneToMany(targetEntity = FilmShow.class, mappedBy = "movie", cascade = CascadeType.REMOVE)
    private Set<FilmShow> filmShows;
}
