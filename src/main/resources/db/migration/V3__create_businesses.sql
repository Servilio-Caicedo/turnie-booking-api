CREATE TABLE businesses (
id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
name VARCHAR(150) NOT NULL,
description VARCHAR(500),
address VARCHAR(255),
phone VARCHAR(30),
timezone VARCHAR(50) NOT NULL,
owner_id BIGINT NOT NULL REFERENCES users (id),
created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_businesses_owner_id ON businesses (owner_id);