package com.maxaramos.hotelbookingjpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.RepositoryDefinition;

import com.maxaramos.hotelbookingjpa.model.Hotel;
import com.maxaramos.hotelbookingjpa.model.Room;

@RepositoryDefinition(
		domainClass = Room.class,
		idClass = Long.class)
public interface RoomDao {

	List<Room> findAllByHotel(Hotel hotel);

	Optional<Room> findByIdAndHotel(Long id, Hotel hotel);

	Room save(Room room);

	void deleteByIdAndHotel(Long id, Hotel hotel);

}
