CREATE TABLE tickets
(
    id             bigint primary key,
    ticket_type    varchar(15),
    ticket_status  varchar(15),
    reservation_id bigint
)