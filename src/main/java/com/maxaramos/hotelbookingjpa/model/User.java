package com.maxaramos.hotelbookingjpa.model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User implements UserDetails {

	private static final long serialVersionUID = -5689181961184462831L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Embedded
	private ContactDetails contactDetails;

	@Embedded
	private Address address;

	@Transient
	private boolean accountNonLocked = true;

	@Transient
	private boolean accountNonExpired = true;

	@Transient
	private boolean credentialsNonExpired = true;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(role);
	}

	public String getFullName() {
		if (StringUtils.isEmpty(firstName) && StringUtils.isEmpty(lastName)) {
			return null;
		}

		if (StringUtils.isEmpty(firstName)) {
			return lastName;
		}

		if (StringUtils.isEmpty(lastName)) {
			return firstName;
		}

		return firstName + " " + lastName;
	}

}
