package com.maxaramos.hotelbookingjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maxaramos.hotelbookingjpa.dao.HotelDao;
import com.maxaramos.hotelbookingjpa.model.Hotel;

@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelDao hotelDao;

	public List<Hotel> findAll() {
		return hotelDao.findAll();
	}

	public Hotel findById(Long id) {
		return hotelDao.findById(id).orElse(null);
	}

	public Hotel add(Hotel hotel) {
		hotel.setId(null);
		hotel.setActive(false);
		return hotelDao.save(hotel);
	}

	public Hotel update(Long id, Hotel hotel) {
		Hotel updatedHotel = hotelDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Hotel [id=%s] not found.", id)));
		updatedHotel.setName(hotel.getName());
		updatedHotel.setContactDetails(hotel.getContactDetails());
		updatedHotel.setAddress(hotel.getAddress());
		return hotelDao.save(updatedHotel);
	}

	public void deleteById(Long id) {
		hotelDao.deleteById(id);
	}

}
