package com.maxaramos.hotelbookingjpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maxaramos.hotelbookingjpa.dao.HotelDao;
import com.maxaramos.hotelbookingjpa.model.Hotel;

@Service
@Transactional
@PreAuthorize("hasRole('ADMIN')")
public class HotelService {

	@Autowired
	private HotelDao hotelDao;

	public List<Hotel> findAll() {
		return hotelDao.findAll();
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
	public Hotel findById(Long id) {
		return hotelDao.findById(id).orElse(null);
	}

	public List<Hotel> findByNameOrAddress(String searchParam) {
		Hotel hotel = new Hotel();
		hotel.setName(searchParam);
		hotel.setCity(searchParam);
		hotel.setState(searchParam);
		hotel.setCountry(searchParam);

		ExampleMatcher matcher = ExampleMatcher.matchingAny()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING);

		List<Hotel> results = new ArrayList<>();
		hotelDao.findAll(Example.of(hotel, matcher)).forEach(results::add);
		return results;
	}

	public Hotel add(Hotel hotel) {
		hotel.setId(null);
		hotel.setEnabled(false);
		hotel.setActive(false);
		return hotelDao.save(hotel);
	}

	public Hotel update(Long id, Hotel hotel) {
		Hotel updatedHotel = hotelDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Hotel [id=%s] not found.", id)));
		updatedHotel.setName(hotel.getName());
		updatedHotel.setEmail(hotel.getEmail());
		updatedHotel.setPhoneNumber(hotel.getPhoneNumber());
		updatedHotel.setCity(hotel.getCity());
		updatedHotel.setState(hotel.getState());
		updatedHotel.setCountry(hotel.getCountry());
		return hotelDao.save(updatedHotel);
	}

	public Hotel enable(Long id) {
		Hotel updatedHotel = hotelDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Hotel [id=%s] not found.", id)));
		updatedHotel.setEnabled(true);
		return hotelDao.save(updatedHotel);
	}

	public Hotel disable(Long id) {
		Hotel updatedHotel = hotelDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Hotel [id=%s] not found.", id)));
		updatedHotel.setEnabled(false);
		return hotelDao.save(updatedHotel);
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
	public Hotel activate(Long id) {
		Hotel updatedHotel = hotelDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Hotel [id=%s] not found.", id)));
		updatedHotel.setActive(true);
		return hotelDao.save(updatedHotel);
	}

	@PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
	public Hotel deactivate(Long id) {
		Hotel updatedHotel = hotelDao.findById(id).orElseThrow(() -> new RuntimeException(String.format("Hotel [id=%s] not found.", id)));
		updatedHotel.setActive(false);
		return hotelDao.save(updatedHotel);
	}

	public void delete(Long id) {
		hotelDao.deleteById(id);
	}

}
