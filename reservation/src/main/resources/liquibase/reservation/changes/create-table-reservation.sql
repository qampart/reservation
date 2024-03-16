CREATE SEQUENCE reservation_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE reservations
(
    id                 BIGINT PRIMARY KEY DEFAULT nextval('reservation_sequence'),
    start_date         DATE,
    end_date           DATE,
    reservation_status VARCHAR(15),
    film_show_id       BIGINT
);
