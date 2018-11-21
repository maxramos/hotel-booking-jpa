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

import com.maxaramos.hotelbookingjpa.model.Role;
import com.maxaramos.hotelbookingjpa.model.User;
import com.maxaramos.hotelbookingjpa.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("users", userService.findAll());
		return "/user/list";
	}

	@GetMapping("/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userService.findById(id));
		return "/user/details";
	}

	@GetMapping("/search/byUsernameOrName")
	public String findByUsernameOrName(@RequestParam("searchParam") String searchParam, Model model) {
		model.addAttribute("users", userService.findByUsernameOrName(searchParam));
		return "/user/list";
	}

	@GetMapping("/add/manager")
	public String showAddManager(Model model) {
		model.addAttribute("user", User.newInstance());
		model.addAttribute("roleName", Role.MANAGER);
		return "/user/add";
	}

	@PostMapping("/add/manager")
	public String addManager(User user, RedirectAttributes redirectAttributes) {
		userService.addManager(user);
		redirectAttributes.addFlashAttribute("successMessage", "Manager added.");
		return "redirect:/hotels";
	}

	@GetMapping("/add/receptionist")
	public String showAddReceptionist(Model model) {
		model.addAttribute("user", User.newInstance());
		model.addAttribute("roleName", Role.RECEPTIONIST);
		return "/user/add";
	}

	@PostMapping("/add/receptionist")
	public String addreceptionist(User user, RedirectAttributes redirectAttributes) {
		userService.addReceptionist(user);
		redirectAttributes.addFlashAttribute("successMessage", "Receptionist added.");
		return "redirect:/hotels";
	}

}
