CREATE TABLE time_off (
id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
resource_id BIGINT NOT NULL REFERENCES resources (id) ON DELETE CASCADE,
start_at TIMESTAMPTZ NOT NULL,
end_at TIMESTAMPTZ NOT NULL,
reason VARCHAR(255),
CHECK (end_at > start_at)
);

CREATE INDEX idx_time_off_resource_range ON time_off (resource_id, start_at, end_at);