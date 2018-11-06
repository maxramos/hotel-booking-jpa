package com.maxaramos.hotelbookingjpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.RepositoryDefinition;

import com.maxaramos.hotelbookingjpa.model.Room;

@RepositoryDefinition(
		domainClass = Room.class,
		idClass = Long.class)
public interface RoomDao {

	List<Room> findAll();

	Optional<Room> findById(Long id);

	Room save(Room room);

	void deleteById(Long id);

}
