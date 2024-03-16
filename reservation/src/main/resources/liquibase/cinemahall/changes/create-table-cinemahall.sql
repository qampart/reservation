CREATE SEQUENCE cinema_halls_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE cinema_halls
(
    id       BIGINT PRIMARY KEY DEFAULT nextval('cinema_halls_seq'),
    name     VARCHAR(50) NOT NULL,
    capacity INT         NOT NULL
);
