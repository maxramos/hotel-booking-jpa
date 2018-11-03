package com.maxaramos.hotelbookingjpa.dao;

import java.util.Optional;

import org.springframework.data.repository.RepositoryDefinition;

import com.maxaramos.hotelbookingjpa.model.User;

@RepositoryDefinition(
		domainClass = User.class,
		idClass = Long.class)
public interface UserDao {

	Optional<User> findByUsername(String username);

}
