package com.maxaramos.hotelbookingjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maxaramos.hotelbookingjpa.model.Hotel;
import com.maxaramos.hotelbookingjpa.service.HotelService;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("hotels", hotelService.findAll());
		return "/hotel/list";
	}

	@GetMapping("/{id}/details")
	public String details(@PathVariable("id") Long id, Model model) {
		model.addAttribute("hotel", hotelService.findById(id));
		return "/hotel/details";
	}

	@PostMapping("/update")
	public String update(Hotel hotel) {
		hotelService.save(hotel);
		return String.format("redirect:/hotel/%s/details", hotel.getId());
	}

}
