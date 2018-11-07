package com.maxaramos.hotelbookingjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maxaramos.hotelbookingjpa.dao.HotelDao;
import com.maxaramos.hotelbookingjpa.dao.RoomDao;
import com.maxaramos.hotelbookingjpa.model.Hotel;
import com.maxaramos.hotelbookingjpa.model.Room;

@Service
@Transactional
public class RoomService {

	@Autowired
	private RoomDao roomDao;

	@Autowired
	private HotelDao hotelDao;

	public List<Room> findAllByHotelId(Long hotelId) {
		Hotel hotel = hotelDao.findById(hotelId).orElseThrow(() -> new RuntimeException(String.format("Hotel [id=%s] not found.", hotelId)));
		return roomDao.findAllByHotel(hotel);
	}

	public Room findByHotelIdAndRoomId(Long hotelId, Long roomId) {
		Hotel hotel = hotelDao.findById(hotelId).orElseThrow(() -> new RuntimeException(String.format("Hotel [id=%s] not found.", hotelId)));
		return roomDao.findByIdAndHotel(roomId, hotel).orElse(null);
	}

	public Room add(Long hotelId, Room room) {
		Hotel hotel = hotelDao.findById(hotelId).orElseThrow(() -> new RuntimeException(String.format("Hotel [id=%s] not found.", hotelId)));
		hotel.addRoom(room);

		room.setId(null);
		room.setActive(false);
		room.setHotel(hotel);
		return roomDao.save(room);
	}

	public Room update(Long hotelId, Long roomId, Room room) {
		Hotel hotel = hotelDao.findById(hotelId).orElseThrow(() -> new RuntimeException(String.format("Hotel [id=%s] not found.", hotelId)));
		Room updatedRoom = roomDao.findByIdAndHotel(roomId, hotel).orElseThrow(() -> new RuntimeException(String.format("Room [id=%s] not found.", roomId)));
		updatedRoom.setRoomNumber(room.getRoomNumber());
		updatedRoom.setRate(room.getRate());
		return roomDao.save(updatedRoom);
	}

	public void delete(Long hotelId, Long roomId) {
		Hotel hotel = hotelDao.findById(hotelId).orElseThrow(() -> new RuntimeException(String.format("Hotel [id=%s] not found.", hotelId)));
		roomDao.deleteByIdAndHotel(roomId, hotel);
	}

}
