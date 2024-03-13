package com.system.reservation.filmshow.service;

import com.system.reservation.filmshow.model.FilmShow;
import com.system.reservation.filmshow.repository.FilmShowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FilmShowService {

    private final FilmShowRepository filmShowRepository;

    public List<FilmShow> getAllFilmShows() {
        return filmShowRepository.findAll();
    }

    public Optional<FilmShow> getFilmShowById(Long id) {
        return filmShowRepository.findById(id);
    }

    public FilmShow addFilmShow(FilmShow filmShow) {
        return filmShowRepository.save(filmShow);
    }


}
