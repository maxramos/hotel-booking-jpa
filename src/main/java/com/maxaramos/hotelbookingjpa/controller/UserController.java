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

	@GetMapping("/add")
	public String showAddManager(Model model) {
		model.addAttribute("user", User.newInstance());
		return "/user/add";
	}

	@PostMapping("/add/manager")
	public String addManager(User user, RedirectAttributes redirectAttributes) {
		userService.addManager(user);
		redirectAttributes.addFlashAttribute("successMessage", "Manager added.");
		return "redirect:/users";
	}

	@PostMapping("/add/receptionist")
	public String addReceptionist(User user, RedirectAttributes redirectAttributes) {
		userService.addReceptionist(user);
		redirectAttributes.addFlashAttribute("successMessage", "Receptionist added.");
		return "redirect:/users";
	}

	@PostMapping("/add/guest")
	public String addGuest(User user, RedirectAttributes redirectAttributes) {
		userService.addGuest(user);
		redirectAttributes.addFlashAttribute("successMessage", "Guest added.");
		return "redirect:/users";
	}

	@PostMapping("/{id}")
	public String update(@PathVariable("id") Long id, User user, RedirectAttributes redirectAttributes) {
		userService.update(id, user);
		redirectAttributes.addFlashAttribute("successMessage", "User updated.");
		return "redirect:/users/" + id;
	}

	@PostMapping("/{id}/changePassword")
	public String changePassword(@PathVariable("id") Long id, User user, RedirectAttributes redirectAttributes) {
		userService.changePassword(id, user);
		redirectAttributes.addFlashAttribute("successMessage", "Password changed.");
		return "redirect:/users/" + id;
	}

	@PostMapping("/{id}/enable")
	public String enable(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		userService.enable(id);
		redirectAttributes.addFlashAttribute("successMessage", "User enabled.");
		return "redirect:/users/" + id;
	}

	@PostMapping("/{id}/disable")
	public String disable(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		userService.disable(id);
		redirectAttributes.addFlashAttribute("successMessage", "User disabled.");
		return "redirect:/users/" + id;
	}

	@PostMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		userService.delete(id);
		redirectAttributes.addFlashAttribute("successMessage", "User deleted.");
		return "redirect:/users";
	}

}
