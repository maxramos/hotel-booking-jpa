package com.maxaramos.hotelbookingjpa.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxaramos.hotelbookingjpa.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomRestController {

	@Autowired
	private RoomService roomService;

}
