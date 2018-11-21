package com.maxaramos.hotelbookingjpa.dao;

import java.util.Optional;

import org.springframework.data.repository.RepositoryDefinition;

import com.maxaramos.hotelbookingjpa.model.Role;

@RepositoryDefinition(
		domainClass = Role.class,
		idClass = Long.class)
public interface RoleDao {

	Optional<Role> findByName(String name);

}
