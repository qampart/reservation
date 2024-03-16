package com.system.reservation.movie.model;

import com.system.reservation.filmshow.model.FilmShow;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<FilmShow> filmShows;


}
