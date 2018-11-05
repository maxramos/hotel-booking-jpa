-- *** ROLE ***
INSERT INTO role(id, name) VALUES(1, 'ROLE_ADMIN');
INSERT INTO role(id, name) VALUES(2, 'ROLE_MANAGER');
INSERT INTO role(id, name) VALUES(3, 'ROLE_RECEPTIONIST');
INSERT INTO role(id, name) VALUES(4, 'ROLE_GUEST');

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- *** USER ***
-- Default Password: changeit
-- Digest auth requires plain text password instead of encoded.

-- Admin
INSERT INTO user(id, username, password, role_id, enabled, email)
VALUES(1, 'maxaramos', '$2a$10$wTrJXHGYS31v1jSVUdACoelFSHA.g13eBA.wjQnkb56rzAJPUlW8y', 1, TRUE, 'maxaramos@gmail.com');
--VALUES(1, 'maxaramos', 'changeit', 1, TRUE);

-- Manager
INSERT INTO user(id, username, password, role_id, enabled, first_name, last_name, email)
VALUES(2, 'm.axa.ramos', '$2a$10$wTrJXHGYS31v1jSVUdACoelFSHA.g13eBA.wjQnkb56rzAJPUlW8y', 2, TRUE, 'Hotel1', 'Manager', 'm.axa.ramos@gmail.com');
INSERT INTO user(id, username, password, role_id, enabled, first_name, last_name, email)
VALUES(3, 'ma.xa.ramos', '$2a$10$wTrJXHGYS31v1jSVUdACoelFSHA.g13eBA.wjQnkb56rzAJPUlW8y', 2, TRUE, 'Hotel2', 'Manager', 'ma.xa.ramos@gmail.com');

-- Receptionist
INSERT INTO user(id, username, password, role_id, enabled, first_name, last_name, email)
VALUES(4, 'm.axar.amos', '$2a$10$wTrJXHGYS31v1jSVUdACoelFSHA.g13eBA.wjQnkb56rzAJPUlW8y', 3, TRUE, 'Hotel1', 'Receptionist1', 'm.axar.amos@gmail.com');
INSERT INTO user(id, username, password, role_id, enabled, first_name, last_name, email)
VALUES(5, 'm.axara.mos', '$2a$10$wTrJXHGYS31v1jSVUdACoelFSHA.g13eBA.wjQnkb56rzAJPUlW8y', 3, TRUE, 'Hotel1', 'Receptionist2', 'm.axara.mos@gmail.com');
INSERT INTO user(id, username, password, role_id, enabled, first_name, last_name, email)
VALUES(6, 'ma.xar.amos', '$2a$10$wTrJXHGYS31v1jSVUdACoelFSHA.g13eBA.wjQnkb56rzAJPUlW8y', 3, TRUE, 'Hotel2', 'Receptionist1', 'ma.xar.amos@gmail.com');
INSERT INTO user(id, username, password, role_id, enabled, first_name, last_name, email)
VALUES(7, 'ma.xara.mos', '$2a$10$wTrJXHGYS31v1jSVUdACoelFSHA.g13eBA.wjQnkb56rzAJPUlW8y', 3, TRUE, 'Hotel2', 'Receptionist2', 'ma.xara.mos@gmail.com');

-- Guest
INSERT INTO user(id, username, password, role_id, enabled, first_name, last_name, email, address1, city, state, country, zip_code)
VALUES(8, 'max.ar.amos', '$2a$10$wTrJXHGYS31v1jSVUdACoelFSHA.g13eBA.wjQnkb56rzAJPUlW8y', 4, TRUE, 'Registered', 'Guest1', 'max.ar.amos@gmail.com', 'Rada St. Legazpi Village', 'Makati', 'Metro Manila', 'Philippines', '1229');
INSERT INTO user(id, username, password, role_id, enabled, first_name, last_name, email, address1, city, state, country, zip_code)
VALUES(9, 'max.ara.mos', '$2a$10$wTrJXHGYS31v1jSVUdACoelFSHA.g13eBA.wjQnkb56rzAJPUlW8y', 4, TRUE, 'Registered', 'Guest2', 'max.ara.mos@gmail.com', 'Dela Rosa St. Legazpi Village', 'Makati', 'Metro Manila', 'Philippines', '1229');
INSERT INTO user(id, username, password, role_id, enabled, first_name, last_name, email, address1, city, state, country, zip_code)
VALUES(10, 'max.aram.os', '$2a$10$wTrJXHGYS31v1jSVUdACoelFSHA.g13eBA.wjQnkb56rzAJPUlW8y', 4, TRUE, 'Registered', 'Guest3', 'max.aram.os@gmail.com', 'Banahaw St. Calmar Homes', 'Lucena', 'Quezon', 'Philippines', '4301');
INSERT INTO user(id, username, password, role_id, enabled, first_name, last_name, email, address1, city, state, country, zip_code)
VALUES(11, 'max.aramo.s', '$2a$10$wTrJXHGYS31v1jSVUdACoelFSHA.g13eBA.wjQnkb56rzAJPUlW8y', 4, TRUE, 'Registered', 'Guest4', 'max.aramo.s@gmail.com', 'Alvarez St. Alvarez Subd.', 'Pagbilao', 'Quezon', 'Philippines', '4301');

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- *** HOTEL ***
INSERT INTO hotel(id, name, active, manager_user_id, email, mobile_number, landline, address1, city, state, country, zip_code)
VALUES(1, 'Hotel1', TRUE, 2, 'm.axaramos@gmail.com', '+639171234567', '+63421234567', 'Ayala Ave.', 'Makati', 'Metro Manila', 'Philippines', '1229');
INSERT INTO hotel(id, name, active, manager_user_id, email, mobile_number, landline, address1, city, state, country, zip_code)
VALUES(2, 'Hotel2', TRUE, 3, 'ma.xaramos@gmail.com', '+639177654321', '+63427654321', 'Main Domoit', 'Lucena', 'Quezon', 'Philippines', '4301');

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- *** HOTEL RECEPTIONIST ***
INSERT INTO hotel_receptionist(hotel_id, receptionist_user_id) VALUES(1, 4);
INSERT INTO hotel_receptionist(hotel_id, receptionist_user_id) VALUES(1, 5);
INSERT INTO hotel_receptionist(hotel_id, receptionist_user_id) VALUES(2, 6);
INSERT INTO hotel_receptionist(hotel_id, receptionist_user_id) VALUES(2, 7);

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- *** ROOM ***
INSERT INTO room(id, room_number, hotel_id, active, rate) VALUES(1, '001', 1, TRUE, 6000.00);
INSERT INTO room(id, room_number, hotel_id, active, rate) VALUES(2, '002', 1, TRUE, 10500.00);
INSERT INTO room(id, room_number, hotel_id, active, rate) VALUES(3, '001', 2, TRUE, 7000.00);
INSERT INTO room(id, room_number, hotel_id, active, rate) VALUES(4, '002', 2, TRUE, 11500.00);
