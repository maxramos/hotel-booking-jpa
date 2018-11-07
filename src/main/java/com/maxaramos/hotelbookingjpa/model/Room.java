package com.maxaramos.hotelbookingjpa.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.maxaramos.hotelbookingjpa.jsonview.CollectionView;
import com.maxaramos.hotelbookingjpa.jsonview.ItemView;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "room")
@Getter
@Setter
@EqualsAndHashCode(of = "roomNumber")
public class Room implements Serializable {

	private static final long serialVersionUID = -4160169401583423335L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonView({ CollectionView.class, ItemView.class })
	private Long id;

	@Column(name = "room_number")
	@JsonView({ CollectionView.class, ItemView.class })
	private String roomNumber;

	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	@Column(name = "active")
	@JsonView({ CollectionView.class, ItemView.class })
	private boolean active;

	@Column(name = "rate")
	@JsonView({ CollectionView.class, ItemView.class })
	private BigDecimal rate;

}
