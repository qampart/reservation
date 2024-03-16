package com.system.reservation.cinemahall.model;

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
@Table(name = "cinema_halls")
public class CinemaHall {

    @Id
    @SequenceGenerator(name = "cinema_halls_seq", sequenceName = "cinema_halls_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinema_halls_seq")
    private Long id;
    private String name;
    private Integer capacity;
    @OneToMany(mappedBy = "cinemaHall", cascade = CascadeType.ALL)
    private List<FilmShow> filmShows;

}
