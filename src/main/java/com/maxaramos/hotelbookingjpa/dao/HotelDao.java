package com.maxaramos.hotelbookingjpa.dao;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

import com.maxaramos.hotelbookingjpa.model.Hotel;

@RepositoryDefinition(
		domainClass = Hotel.class,
		idClass = Long.class)
public interface HotelDao {

	List<Hotel> findAll();

}
