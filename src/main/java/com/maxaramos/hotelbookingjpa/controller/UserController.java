package com.maxaramos.hotelbookingjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maxaramos.hotelbookingjpa.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("hotels", userService.findAll());
		return "/user/list";
	}

	@GetMapping("/search/byUsernameOrNameOrEmail")
	public String findByUsernameOrNameOrEmail(@RequestParam("searchParam") String searchParam, Model model) {
		model.addAttribute("hotels", userService.findByUsernameOrNameOrEmail(searchParam));
		return "/hotel/list";
	}

}
