CREATE TABLE professional_services (
professional_id BIGINT NOT NULL REFERENCES professionals (id) ON DELETE CASCADE,
service_id BIGINT NOT NULL REFERENCES services (id) ON DELETE CASCADE,
PRIMARY KEY (professional_id, service_id)
);

CREATE INDEX idx_professional_services_service_id ON professional_services (service_id);