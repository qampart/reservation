ALTER TABLE tickets
    ADD FOREIGN KEY (reservation_id)
        REFERENCES reservations (id);