BEGIN;

INSERT INTO users (name, email, password_hash, role) VALUES
('Dueño', 'owner@test.com', 'x', 'OWNER'),
('Cliente', 'client@test.com', 'x', 'CLIENT');

INSERT INTO businesses (name, timezone, owner_id)
SELECT 'Barbería Test', 'America/Bogota', id FROM users WHERE email = 'owner@test.com';

INSERT INTO resources (name, business_id)
SELECT 'Carlos', id FROM businesses WHERE name = 'Barbería Test';

INSERT INTO services (name, reserved_minutes, price, business_id)
SELECT 'Corte', 30, 20000, id FROM businesses WHERE name = 'Barbería Test';

INSERT INTO appointments (client_id, resource_id, service_id, start_at, end_at, price)
SELECT u.id, r.id, s.id, '2026-11-02 10:00-05', '2026-11-02 10:30-05', 20000
FROM users u, resources r, services s
WHERE u.email = 'client@test.com' AND r.name = 'Carlos' AND s.name = 'Corte';

INSERT INTO appointments (client_id, resource_id, service_id, start_at, end_at, price)
SELECT u.id, r.id, s.id, '2026-11-02 10:30-05', '2026-11-02 11:00-05', 20000
FROM users u, resources r, services s
WHERE u.email = 'client@test.com' AND r.name = 'Carlos' AND s.name = 'Corte';

INSERT INTO appointments (client_id, resource_id, service_id, start_at, end_at, status, price)
SELECT u.id, r.id, s.id, '2026-11-02 10:00-05', '2026-11-02 10:30-05', 'CANCELLED', 20000
FROM users u, resources r, services s
WHERE u.email = 'client@test.com' AND r.name = 'Carlos' AND s.name = 'Corte';

INSERT INTO appointments (client_id, resource_id, service_id, start_at, end_at, price)
SELECT u.id, r.id, s.id, '2026-11-02 10:15-05', '2026-11-02 10:45-05', 20000
FROM users u, resources r, services s
WHERE u.email = 'client@test.com' AND r.name = 'Carlos' AND s.name = 'Corte';

ROLLBACK;