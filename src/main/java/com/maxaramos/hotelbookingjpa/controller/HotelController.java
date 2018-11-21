package com.maxaramos.hotelbookingjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@GetMapping("/search/byNameOrAddress")
	public String findByNameOrAddress(@RequestParam("searchParam") String searchParam, Model model) {
		model.addAttribute("hotels", hotelService.findByNameOrAddress(searchParam));
		return "/hotel/list";
	}

	@GetMapping("/add")
	public String showAdd(Model model) {
		model.addAttribute("hotel", Hotel.newInstance());
		return "/hotel/add";
	}

	@PostMapping("/add")
	public String add(Hotel hotel, RedirectAttributes redirectAttributes) {
		hotelService.add(hotel);
		redirectAttributes.addFlashAttribute("successMessage", "Hotel added.");
		return "redirect:/hotels";
	}

	@PostMapping("/{id}")
	public String update(@PathVariable("id") Long id, Hotel hotel, RedirectAttributes redirectAttributes) {
		hotelService.update(id, hotel);
		redirectAttributes.addFlashAttribute("successMessage", "Hotel updated.");
		return "redirect:/hotels/" + id;
	}

	@PostMapping("/{id}/enable")
	public String enable(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		hotelService.enable(id);
		redirectAttributes.addFlashAttribute("successMessage", "Hotel enabled.");
		return "redirect:/hotels/" + id;
	}

	@PostMapping("/{id}/disable")
	public String disable(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		hotelService.disable(id);
		redirectAttributes.addFlashAttribute("successMessage", "Hotel disabled.");
		return "redirect:/hotels/" + id;
	}

	@PostMapping("/{id}/activate")
	public String activate(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		hotelService.activate(id);
		redirectAttributes.addFlashAttribute("successMessage", "Hotel activated.");
		return "redirect:/hotels/" + id;
	}

	@PostMapping("/{id}/deactivate")
	public String deactivate(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		hotelService.deactivate(id);
		redirectAttributes.addFlashAttribute("successMessage", "Hotel deactivated.");
		return "redirect:/hotels/" + id;
	}

	@PostMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		hotelService.delete(id);
		redirectAttributes.addFlashAttribute("successMessage", "Hotel deleted.");
		return "redirect:/hotels";
	}

}
