CREATE TABLE role (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(17) NOT NULL UNIQUE
);

CREATE TABLE user (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(20) NOT NULL UNIQUE,
	password VARCHAR(60) NOT NULL,
	role_id BIGINT REFERENCES role(id),
	enabled BOOLEAN NOT NULL,
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	email VARCHAR(30),
	mobile_number VARCHAR(20),
	landline VARCHAR(20),
	address1 VARCHAR(100),
	address2 VARCHAR(100),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	zip_code VARCHAR(10)
);

CREATE TABLE hotel (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(40) NOT NULL UNIQUE,
	active BOOLEAN NOT NULL,
	manager_user_id BIGINT REFERENCES user(id),
	email VARCHAR(30),
	mobile_number VARCHAR(20),
	landline VARCHAR(20),
	address1 VARCHAR(100),
	address2 VARCHAR(100),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	zip_code VARCHAR(10)
);

CREATE TABLE hotel_receptionist (
	hotel_id BIGINT REFERENCES hotel(id),
	receptionist_user_id BIGINT REFERENCES user(id),
	PRIMARY KEY(hotel_id, receptionist_user_id)
);

CREATE TABLE room (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	room_number VARCHAR(10) NOT NULL UNIQUE,
	hotel_id BIGINT REFERENCES hotel(id),
	active BOOLEAN NOT NULL,
	rate DECIMAL(6,2)
);

CREATE TABLE booking (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	booking_number VARCHAR(10) NOT NULL UNIQUE,
	room_id BIGINT REFERENCES room(id),
	start_date DATE NOT NULL,
	end_date DATE NOT NULL,
	guest_user_id BIGINT REFERENCES user(id),
	first_name VARCHAR(20),
	last_name VARCHAR(20),
	email VARCHAR(30),
	mobile_number VARCHAR(20)
);