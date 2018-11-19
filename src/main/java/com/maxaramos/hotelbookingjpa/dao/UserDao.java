package com.maxaramos.hotelbookingjpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.maxaramos.hotelbookingjpa.model.User;

@RepositoryDefinition(
		domainClass = User.class,
		idClass = Long.class)
public interface UserDao extends QueryByExampleExecutor<User> {

	List<User> findAll();

	Optional<User> findByUsername(String username);

}
