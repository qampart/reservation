ALTER TABLE reservations
    ADD FOREIGN KEY (film_show_id)
        REFERENCES filmshows (id);