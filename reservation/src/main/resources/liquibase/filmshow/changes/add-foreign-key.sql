ALTER TABLE film_shows
    ADD FOREIGN KEY (cinema_hall_id)
        REFERENCES cinema_halls (id);

ALTER TABLE film_shows
    ADD FOREIGN KEY (movie_id)
        REFERENCES movies (id);