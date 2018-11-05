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

	public Hotel save(Hotel hotel) {
		return hotelDao.save(hotel);
	}

}
