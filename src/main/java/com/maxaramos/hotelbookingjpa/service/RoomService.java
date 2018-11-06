package com.maxaramos.hotelbookingjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maxaramos.hotelbookingjpa.dao.RoomDao;
import com.maxaramos.hotelbookingjpa.model.Room;

@Service
@Transactional
public class RoomService {

	@Autowired
	private RoomDao roomDao;

	public List<Room> findAll() {
		return roomDao.findAll();
	}

	public Room findById(Long id) {
		return roomDao.findById(id).orElse(null);
	}

	public Room add(Room room) {
		room.setId(null);
		room.setActive(false);
		return roomDao.save(room);
	}

	public Room update(Long id, Room room) {
		Room updatedRoom = roomDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Room [id=%s] not found.", id)));
		updatedRoom.setRoomNumber(room.getRoomNumber());
		updatedRoom.setRate(room.getRate());
		return roomDao.save(updatedRoom);
	}

	public void deleteById(Long id) {
		roomDao.deleteById(id);
	}

}
