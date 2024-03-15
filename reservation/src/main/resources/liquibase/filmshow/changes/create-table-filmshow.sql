CREATE TABLE filmshows
(
    id                   bigint primary key,
    film_local_date_time timestamp,
    cinema_hall_id       bigint,
    movie_id             bigint
)