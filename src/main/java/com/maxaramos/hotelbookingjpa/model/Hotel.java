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

import com.fasterxml.jackson.annotation.JsonView;
import com.maxaramos.hotelbookingjpa.jsonview.CollectionView;
import com.maxaramos.hotelbookingjpa.jsonview.ItemView;

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

	@Column(name = "active")
	private boolean active;

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

	public static Hotel newInstance() {
		Hotel hotel = new Hotel();
		hotel.setContactDetails(new ContactDetails());
		hotel.setAddress(new Address());
		return hotel;
	}

	@JsonView({ CollectionView.class, ItemView.class })
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonView({ CollectionView.class, ItemView.class })
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonView(ItemView.class)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	@JsonView({ CollectionView.class, ItemView.class })
	public String getManagerFullName() {
		if (manager == null) {
			return null;
		}

		return manager.getFullName();
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

	@JsonView(ItemView.class)
	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	@JsonView(ItemView.class)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
