package com.maxaramos.hotelbookingjpa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("registered_guest_booking")
public class RegisteredGuestBooking extends Booking {

	private static final long serialVersionUID = 1043714645007006025L;

	@ManyToOne
	@JoinColumn(name = "guest_user_id")
	private User guest;

	public User getGuest() {
		return guest;
	}

	public void setGuest(User guest) {
		this.guest = guest;
	}

}
