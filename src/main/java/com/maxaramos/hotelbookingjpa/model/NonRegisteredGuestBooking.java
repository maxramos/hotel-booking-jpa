package com.maxaramos.hotelbookingjpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("non_registered_guest_booking")
@Getter
@Setter
public class NonRegisteredGuestBooking extends Booking {

	private static final long serialVersionUID = 7139745070593743387L;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

}
