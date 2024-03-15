ALTER TABLE seat_tickets
    ADD FOREIGN KEY (ticket_id)
        REFERENCES tickets (id);

ALTER TABLE seat_tickets
    ADD FOREIGN KEY (seat_id)
        REFERENCES seats (id);