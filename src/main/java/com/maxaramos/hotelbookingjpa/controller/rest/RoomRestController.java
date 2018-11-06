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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.maxaramos.hotelbookingjpa.jsonview.CollectionView;
import com.maxaramos.hotelbookingjpa.jsonview.ItemView;
import com.maxaramos.hotelbookingjpa.model.Room;
import com.maxaramos.hotelbookingjpa.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {

	@Autowired
	private RoomService roomService;

	@GetMapping
	@JsonView(CollectionView.class)
	public List<Room> findAll() {
		return roomService.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(ItemView.class)
	public Room findById(@PathVariable("id") Long id) {
		return roomService.findById(id);
	}

	@PostMapping
	@JsonView(ItemView.class)
	public Room add(@RequestBody Room room) {
		return roomService.add(room);
	}

	@PatchMapping("/{id}")
	@JsonView(ItemView.class)
	public Room update(@PathVariable("id") Long id, @RequestBody Room room) {
		return roomService.update(id, room);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		roomService.deleteById(id);
	}

}
