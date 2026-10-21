CREATE TABLE services (
id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
name VARCHAR(100)  NOT NULL,
description VARCHAR(500),
reserved_minutes  INTEGER NOT NULL CHECK (reserved_minutes > 0),
estimated_minutes INTEGER CHECK (estimated_minutes > 0),
price NUMERIC(10,2) NOT NULL CHECK (price >= 0),
business_id BIGINT  NOT NULL REFERENCES businesses (id),
active BOOLEAN NOT NULL DEFAULT TRUE,
created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_services_business_id ON services (business_id);