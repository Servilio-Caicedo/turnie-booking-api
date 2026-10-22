CREATE TYPE timerange AS RANGE (subtype = time);

CREATE TABLE working_hours (
id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
resource_id BIGINT NOT NULL REFERENCES resources (id) ON DELETE CASCADE,
day_of_week VARCHAR(10) NOT NULL CHECK (day_of_week IN(
    'MONDAY','TUESDAY','WEDNESDAY','THURSDAY','FRIDAY','SATURDAY','SUNDAY'
    )
    ),
start_time TIME NOT NULL,
end_time TIME NOT NULL,
CHECK (end_time > start_time),
EXCLUDE USING gist (
resource_id WITH =,
day_of_week WITH =,
timerange(start_time, end_time) WITH &&
)
);

CREATE INDEX idx_working_hours_resource_id ON working_hours (resource_id);