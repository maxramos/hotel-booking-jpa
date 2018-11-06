package com.maxaramos.hotelbookingjpa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("registered_guest_booking")
@Getter
@Setter
public class RegisteredGuestBooking extends Booking {

	private static final long serialVersionUID = 1043714645007006025L;

	@ManyToOne
	@JoinColumn(name = "guest_user_id")
	private User guest;

}
