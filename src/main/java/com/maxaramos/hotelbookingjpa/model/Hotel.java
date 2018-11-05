package com.maxaramos.hotelbookingjpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {

	private static final long serialVersionUID = -1798484086573139384L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToOne
	@JoinColumn(name = "manager_user_id")
	private User manager;

	@OneToMany
	@JoinTable(name = "hotel_receptionist",
			joinColumns = @JoinColumn(name = "hotel_id", table = "hotel", referencedColumnName = "id"),
			inverseJoinColumns= @JoinColumn(name = "receptionist_user_id", table = "user", referencedColumnName = "id"))
	private List<User> receptionists;

	@OneToMany(mappedBy = "hotel")
	private List<Room> rooms;

	@Embedded
	private ContactDetails contactDetails;

	@Embedded
	private Address address;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public List<User> getReceptionists() {
		return receptionists;
	}

	public void setReceptionists(List<User> receptionists) {
		this.receptionists = receptionists;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
