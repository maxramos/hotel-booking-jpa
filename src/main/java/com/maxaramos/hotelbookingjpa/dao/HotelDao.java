package com.maxaramos.hotelbookingjpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.RepositoryDefinition;

import com.maxaramos.hotelbookingjpa.model.Hotel;

@RepositoryDefinition(
		domainClass = Hotel.class,
		idClass = Long.class)
public interface HotelDao {

	List<Hotel> findAll();

	Optional<Hotel> findById(Long id);

	Hotel save(Hotel hotel);

	void deleteById(Long id);

}
