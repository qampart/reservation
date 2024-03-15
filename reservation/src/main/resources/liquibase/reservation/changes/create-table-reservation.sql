CREATE TABLE reservations
(
    id                bigint primary key,
    start_date         date,
    end_date           date,
    reservation_status varchar(15),
    film_show_id      bigint
)