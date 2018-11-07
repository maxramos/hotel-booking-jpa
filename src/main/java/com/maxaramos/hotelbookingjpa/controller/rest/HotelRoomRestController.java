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
@RequestMapping("/api/hotels/{hotelId}/rooms")
public class HotelRoomRestController {

	@Autowired
	private RoomService roomService;

	@GetMapping
	@JsonView(CollectionView.class)
	public List<Room> findAllByHotelId(@PathVariable("hotelId") Long hotelId) {
		return roomService.findAllByHotelId(hotelId);
	}

	@GetMapping("/{roomId}")
	@JsonView(ItemView.class)
	public Room findByHotelIdAndRoomId(@PathVariable("hotelId") Long hotelId, @PathVariable("roomId") Long roomId) {
		return roomService.findByHotelIdAndRoomId(hotelId, roomId);
	}

	@PostMapping
	@JsonView(ItemView.class)
	public Room add(@PathVariable("hotelId") Long hotelId, @RequestBody Room room) {
		return roomService.add(hotelId, room);
	}

	@PatchMapping("/{roomId}")
	@JsonView(ItemView.class)
	public Room update(@PathVariable("hotelId") Long hotelId, @PathVariable("roomId") Long roomId, @RequestBody Room room) {
		return roomService.update(hotelId, roomId, room);
	}

	@DeleteMapping("/{roomId}")
	public void delete(@PathVariable("hotelId") Long hotelId, @PathVariable("roomId") Long roomId) {
		roomService.delete(hotelId, roomId);
	}

}
