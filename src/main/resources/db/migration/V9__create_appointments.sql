CREATE TABLE appointments (
id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
client_id BIGINT NOT NULL REFERENCES users (id),
resource_id BIGINT NOT NULL REFERENCES resources (id),
service_id BIGINT NOT NULL REFERENCES services (id),
start_at TIMESTAMPTZ NOT NULL,
end_at TIMESTAMPTZ NOT NULL,
status VARCHAR(20) NOT NULL DEFAULT 'CONFIRMED'
CHECK (status IN ('CONFIRMED', 'CANCELLED', 'COMPLETED', 'NO_SHOW')),
price NUMERIC(10,2) NOT NULL CHECK (price >= 0),
cancelled_at TIMESTAMPTZ,
created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
CHECK (end_at > start_at),
EXCLUDE USING gist (
resource_id WITH =,
tstzrange(start_at, end_at) WITH &&
) WHERE (status <> 'CANCELLED')
);

CREATE INDEX idx_appointments_client_id ON appointments (client_id);
CREATE INDEX idx_appointments_resource_start ON appointments (resource_id, start_at);