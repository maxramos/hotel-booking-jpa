-- *** ROLE ***
INSERT INTO role(id, name) VALUES(1, 'ROLE_ADMIN');
INSERT INTO role(id, name) VALUES(2, 'ROLE_MANAGER');
INSERT INTO role(id, name) VALUES(3, 'ROLE_GUEST');

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- *** USER ***
-- Default Password: changeit
-- Digest requires plain text password instead of encoded.

-- Admin
INSERT INTO user(id, username, password, role_id, enabled)
VALUES(1, 'max.a.ramos', '$2a$10$wTrJXHGYS31v1jSVUdACoelFSHA.g13eBA.wjQnkb56rzAJPUlW8y', 1, TRUE);
--VALUES(1, 'max.a.ramos', 'changeit', 1, TRUE);
