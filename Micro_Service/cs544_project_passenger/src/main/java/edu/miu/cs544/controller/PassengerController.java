package edu.miu.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.service.PassengerService;
import edu.miu.cs544.service.response.PassengerResponse;

@RestController
@RequestMapping("passengers")
public class PassengerController {
	@Autowired
	private PassengerService passengerService;
	
	@GetMapping
	public List<PassengerResponse> getAll() {
		return passengerService.getAll();
	}
	
	@GetMapping("/{id}")
	public PassengerResponse getById(@PathVariable Integer id) {
		return passengerService.getById(id);
	}
}
