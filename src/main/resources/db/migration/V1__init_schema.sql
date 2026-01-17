CREATE TABLE room (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    capacity INT NOT NULL
);

CREATE TABLE reservation (
    id BIGSERIAL PRIMARY KEY,
    room_id BIGINT NOT NULL,
    customer_name VARCHAR(255) NOT NULL,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_room FOREIGN KEY (room_id) REFERENCES room(id)
);

INSERT INTO room (name, description, capacity) VALUES
('Room A', 'Large meeting room with projector', 10),
('Room B', 'Small room for interviews', 4);