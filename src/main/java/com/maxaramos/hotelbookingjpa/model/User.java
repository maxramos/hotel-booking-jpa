package com.maxaramos.hotelbookingjpa.model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
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

import com.fasterxml.jackson.annotation.JsonView;
import com.maxaramos.hotelbookingjpa.jsonview.CollectionView;
import com.maxaramos.hotelbookingjpa.jsonview.ItemView;

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
	@JsonView({ CollectionView.class, ItemView.class })
	private Long id;

	@Column(name = "username")
	@JsonView({ CollectionView.class, ItemView.class })
	private String username;

	@Column(name = "password")
	private String password;

	@Transient
	private String rawPassword;

	@Transient
	private String confirmRawPassword;

	@ManyToOne
	@JoinColumn(name = "role_id")
	@JsonView({ CollectionView.class, ItemView.class })
	private Role role;

	@Column(name = "enabled")
	@JsonView({ CollectionView.class, ItemView.class })
	private boolean enabled;

	@Transient
	private boolean accountNonLocked = true;

	@Transient
	private boolean accountNonExpired = true;

	@Transient
	private boolean credentialsNonExpired = true;

	@Column(name = "first_name")
	@JsonView(ItemView.class)
	private String firstName;

	@Column(name = "last_name")
	@JsonView(ItemView.class)
	private String lastName;

	@Column(name = "email")
	@JsonView(ItemView.class)
	private String email;

	@Column(name = "phone_number")
	@JsonView(ItemView.class)
	private String phoneNumber;

	public static User newInstance() {
		User user = new User();
		return user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(role);
	}

	@JsonView(CollectionView.class)
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
