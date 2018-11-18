package com.maxaramos.hotelbookingjpa.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.annotation.JsonView;
import com.maxaramos.hotelbookingjpa.jsonview.CollectionView;
import com.maxaramos.hotelbookingjpa.jsonview.ItemView;
import com.maxaramos.hotelbookingjpa.model.Hotel;
import com.maxaramos.hotelbookingjpa.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelRestController {

	@Autowired
	private HotelService hotelService;

	@GetMapping
	@JsonView(CollectionView.class)
	public List<Hotel> findAll() {
		return hotelService.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(ItemView.class)
	public Hotel findById(@PathVariable("id") Long id) {
		return hotelService.findById(id);
	}

	@GetMapping("/search/byNameOrAddress")
	@JsonView(CollectionView.class)
	public List<Hotel> findByNameOrAddress(@RequestParam("searchParam") String searchParam) {
		return hotelService.findByNameOrAddress(searchParam);
	}

	@PostMapping
	@JsonView(ItemView.class)
	public Hotel add(@RequestBody Hotel hotel) {
		return hotelService.add(hotel);
	}

	@PatchMapping("/{id}")
	@JsonView(ItemView.class)
	public Hotel update(@PathVariable("id") Long id, @RequestBody Hotel hotel) {
		return hotelService.update(id, hotel);
	}

	@PatchMapping("/{id}/enable")
	public void enable(@PathVariable("id") Long id) {
		hotelService.enable(id);
	}

	@PatchMapping("/{id}/disable")
	public void disable(@PathVariable("id") Long id) {
		hotelService.disable(id);
	}

	@PatchMapping("/{id}/activate")
	public void activate(@PathVariable("id") Long id) {
		hotelService.activate(id);
	}

	@PatchMapping("/{id}/deactivate")
	public void deactivate(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		hotelService.deactivate(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		hotelService.delete(id);
	}

}
