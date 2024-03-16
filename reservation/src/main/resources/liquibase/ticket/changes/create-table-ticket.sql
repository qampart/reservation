CREATE SEQUENCE ticket_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE tickets
(
    id             BIGINT PRIMARY KEY DEFAULT nextval('ticket_sequence'),
    ticket_type    VARCHAR(15),
    ticket_status  VARCHAR(15),
    reservation_id BIGINT
);
