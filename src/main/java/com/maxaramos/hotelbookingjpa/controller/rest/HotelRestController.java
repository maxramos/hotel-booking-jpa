package com.maxaramos.hotelbookingjpa.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
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

}
