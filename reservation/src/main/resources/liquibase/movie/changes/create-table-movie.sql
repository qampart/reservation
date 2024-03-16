CREATE SEQUENCE movie_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE movies
(
    id     BIGINT PRIMARY KEY DEFAULT nextval('movie_sequence'),
    name   VARCHAR(255) NOT NULL,
    length INT          NOT NULL
);
