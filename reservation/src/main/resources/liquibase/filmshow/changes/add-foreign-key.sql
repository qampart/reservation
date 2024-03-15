ALTER TABLE filmshows
    ADD FOREIGN KEY (cinema_hall_id)
        REFERENCES cinema_halls (id);

ALTER TABLE filmshows
    ADD FOREIGN KEY (movie_id)
        REFERENCES movies (id);