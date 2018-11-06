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
public class Address implements Serializable {

	private static final long serialVersionUID = -6941096774517202829L;

	@Column(name = "address1")
	@JsonView(ItemView.class)
	private String address1;

	@Column(name = "address2")
	@JsonView(ItemView.class)
	private String address2;

	@Column(name = "city")
	@JsonView(ItemView.class)
	private String city;

	@Column(name = "state")
	@JsonView(ItemView.class)
	private String state;

	@Column(name = "country")
	@JsonView(ItemView.class)
	private String country;

	@Column(name = "zip_code")
	@JsonView(ItemView.class)
	private String zipCode;

}
