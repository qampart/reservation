package com.system.reservation.filmshow.controller;

import com.system.reservation.filmshow.model.FilmShow;
import com.system.reservation.filmshow.service.FilmShowService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/filmshows")
public class FilmShowController {

    private final FilmShowService filmShowService;

    @GetMapping()
    public List<FilmShow> getAllFilmShows(){
        return filmShowService.getAllFilmShows();
    }

    @GetMapping("/{id}")
    public Optional<FilmShow> getFilmShowById(@PathVariable Long id){
        return filmShowService.getFilmShowById(id);
    }

    @PostMapping
    public FilmShow addFilmShow(@RequestBody FilmShow filmShow){
        return filmShowService.addFilmShow(filmShow);
    }
}
