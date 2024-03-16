CREATE SEQUENCE seat_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE seats
(
    id          BIGINT PRIMARY KEY DEFAULT nextval('seat_sequence'),
    seat_number INT
);
