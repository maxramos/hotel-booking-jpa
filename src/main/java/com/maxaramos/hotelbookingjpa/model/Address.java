package com.maxaramos.hotelbookingjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;
import com.maxaramos.hotelbookingjpa.jsonview.DetailsView;

@Embeddable
public class Address implements Serializable {

	private static final long serialVersionUID = -6941096774517202829L;

	@Column(name = "address1")
	private String address1;

	@Column(name = "address2")
	private String address2;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "zip_code")
	private String zipCode;

	@JsonView(DetailsView.class)
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@JsonView(DetailsView.class)
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@JsonView(DetailsView.class)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@JsonView(DetailsView.class)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@JsonView(DetailsView.class)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@JsonView(DetailsView.class)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
