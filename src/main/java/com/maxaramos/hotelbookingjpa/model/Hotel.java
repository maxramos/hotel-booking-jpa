package com.maxaramos.hotelbookingjpa.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonView;
import com.maxaramos.hotelbookingjpa.jsonview.CollectionView;
import com.maxaramos.hotelbookingjpa.jsonview.ItemView;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hotel")
@Getter
@Setter
public class Hotel implements Serializable {

	private static final long serialVersionUID = -1798484086573139384L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonView({ CollectionView.class, ItemView.class })
	private Long id;

	@Column(name = "name")
	@JsonView({ CollectionView.class, ItemView.class })
	private String name;

	@Column(name = "active")
	@JsonView({ CollectionView.class, ItemView.class })
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

	@Column(name = "email")
	@JsonView(ItemView.class)
	private String email;

	@Column(name = "phone_number")
	@JsonView(ItemView.class)
	private String phoneNumber;

	@Column(name = "city")
	@JsonView(ItemView.class)
	private String city;

	@Column(name = "state")
	@JsonView(ItemView.class)
	private String state;

	@Column(name = "country")
	@JsonView(ItemView.class)
	private String country;

	public static Hotel newInstance() {
		Hotel hotel = new Hotel();
		return hotel;
	}

	@JsonView(ItemView.class)
	public String getManagerFullName() {
		if (manager == null) {
			return null;
		}

		return manager.getFullName();
	}

	@JsonView(ItemView.class)
	public List<String> getReceptionistsFullNames() {
		if (CollectionUtils.isEmpty(receptionists)) {
			return Collections.emptyList();
		}

		return receptionists.stream().map(User::getFullName).collect(Collectors.toList());
	}

	@JsonView({ CollectionView.class, ItemView.class })
	public int getRoomsCount() {
		if (CollectionUtils.isEmpty(rooms)) {
			return 0;
		}

		return rooms.size();
	}

}
