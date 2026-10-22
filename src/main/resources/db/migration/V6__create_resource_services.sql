CREATE TABLE resource_services (
resource_id BIGINT NOT NULL REFERENCES resources (id) ON DELETE CASCADE,
service_id BIGINT NOT NULL REFERENCES services (id) ON DELETE CASCADE,
PRIMARY KEY (resource_id, service_id)
);

CREATE INDEX idx_resource_services_service_id ON resource_services (service_id);