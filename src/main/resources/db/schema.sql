CREATE TABLE role (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(17) NOT NULL UNIQUE
);

CREATE TABLE user (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL UNIQUE,
	password VARCHAR(60) NOT NULL,
	role_id BIGINT NOT NULL,
	enabled BOOLEAN NOT NULL,
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	email VARCHAR(30),
	phone_number VARCHAR(20),
	FOREIGN KEY(role_id) REFERENCES role(id)
);

CREATE TABLE hotel (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(40) NOT NULL UNIQUE,
	active BOOLEAN NOT NULL,
	manager_user_id BIGINT REFERENCES user(id),
	email VARCHAR(30),
	phone_number VARCHAR(20),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20)
);

CREATE TABLE hotel_receptionist (
	hotel_id BIGINT REFERENCES hotel(id),
	receptionist_user_id BIGINT REFERENCES user(id),
	PRIMARY KEY(hotel_id, receptionist_user_id)
);

CREATE TABLE room (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	room_number VARCHAR(10) NOT NULL,
	hotel_id BIGINT NOT NULL,
	active BOOLEAN NOT NULL,
	rate DECIMAL(8,2),
	FOREIGN KEY(hotel_id) REFERENCES hotel(id)
);

CREATE TABLE booking (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	booking_type VARCHAR(28) NOT NULL,
	booking_number VARCHAR(10) NOT NULL UNIQUE,
	room_id BIGINT NOT NULL,
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	guest_user_id BIGINT REFERENCES user(id),
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	email VARCHAR(30),
	phone_number VARCHAR(20),
	FOREIGN KEY(room_id) REFERENCES room(id),
);