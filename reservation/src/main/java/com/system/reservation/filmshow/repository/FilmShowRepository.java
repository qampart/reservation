package com.system.reservation.filmshow.repository;

import com.system.reservation.filmshow.model.FilmShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmShowRepository extends JpaRepository<FilmShow, Long> {
}
