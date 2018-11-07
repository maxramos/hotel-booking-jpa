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
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("hotels", hotelService.findAll());
		return "/hotel/list";
	}

	@GetMapping("/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {
		model.addAttribute("hotel", hotelService.findById(id));
		return "/hotel/details";
	}

	@GetMapping("/add")
	public String showAdd(Model model) {
		model.addAttribute("hotel", Hotel.newInstance());
		return "/hotel/add";
	}

	@PostMapping
	public String add(Hotel hotel) {
		Hotel addedHotel = hotelService.add(hotel);
		return "redirect:/hotels/" + addedHotel.getId();
	}

	@PostMapping("/{id}")
	public String update(@PathVariable("id") Long id, Hotel hotel) {
		hotelService.update(id, hotel);
		return "redirect:/hotels/" + id;
	}

	@PostMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		hotelService.delete(id);
		return "redirect:/hotels";
	}

}
