CREATE SEQUENCE film_show_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE film_shows
(
    id                   BIGINT PRIMARY KEY DEFAULT nextval('film_show_sequence'),
    film_local_date_time TIMESTAMP,
    cinema_hall_id       BIGINT,
    movie_id             BIGINT
);
