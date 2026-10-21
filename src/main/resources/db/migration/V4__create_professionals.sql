CREATE TABLE professionals (
id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
name VARCHAR(100) NOT NULL,
business_id BIGINT NOT NULL REFERENCES businesses (id),
active BOOLEAN NOT NULL DEFAULT TRUE,
created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX idx_professionals_business_id ON professionals (business_id);