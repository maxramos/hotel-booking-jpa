package com.maxaramos.hotelbookingjpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;

@Entity
@Table(name = "role")
@Getter
public class Role implements GrantedAuthority {

	public static final String ADMIN = "admin";
	public static final String MANAGER = "manager";
	public static final String RECEPTIONIST = "receptionist";
	public static final String GUEST = "guest";

	private static final long serialVersionUID = 7191207013807877084L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Override
	public String getAuthority() {
		return "ROLE_" + name.toUpperCase();
	}

}
