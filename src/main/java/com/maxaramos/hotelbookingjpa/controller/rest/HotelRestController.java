package com.maxaramos.hotelbookingjpa.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.maxaramos.hotelbookingjpa.jsonview.DetailsView;
import com.maxaramos.hotelbookingjpa.jsonview.ListView;
import com.maxaramos.hotelbookingjpa.model.Hotel;
import com.maxaramos.hotelbookingjpa.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelRestController {

	@Autowired
	private HotelService hotelService;

	@GetMapping
	@JsonView(ListView.class)
	public List<Hotel> list() {
		return hotelService.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(DetailsView.class)
	public Hotel details(@PathVariable("id") Long id) {
		return hotelService.findById(id);
	}

	@PutMapping
	@JsonView(DetailsView.class)
	public Hotel update(@RequestBody Hotel hotel) {
		return hotelService.save(hotel);
	}

}
