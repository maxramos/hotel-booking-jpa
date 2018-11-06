package com.maxaramos.hotelbookingjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;
import com.maxaramos.hotelbookingjpa.jsonview.ItemView;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class ContactDetails implements Serializable {

	private static final long serialVersionUID = 1200929809803006089L;

	@Column(name = "email")
	@JsonView(ItemView.class)
	private String email;

	@Column(name = "mobile_number")
	@JsonView(ItemView.class)
	private String mobileNumber;

	@Column(name = "landline")
	@JsonView(ItemView.class)
	private String landline;

}
