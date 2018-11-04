package com.maxaramos.hotelbookingjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name = "manager_id")
	private User manager;

}
