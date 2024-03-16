CREATE SEQUENCE seat_tickets_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE seat_tickets
(
    id        BIGINT PRIMARY KEY DEFAULT nextval('seat_tickets_sequence'),
    ticket_id BIGINT,
    seat_id   BIGINT
);
