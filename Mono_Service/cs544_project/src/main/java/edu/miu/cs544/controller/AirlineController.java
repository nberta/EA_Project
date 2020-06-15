package edu.miu.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.domain.Airline;
import edu.miu.cs544.service.AirlineService;

@RestController
@RequestMapping("/airlines")
public class AirlineController {
	@Autowired
	private AirlineService airlineService;
	
	@GetMapping
	public List<Airline> getAll() {
		return airlineService.getAll();
	}
	
	@GetMapping(params = {"code"})
	public Airline getByCode(@RequestParam String code) {
		return airlineService.getByCode(code);
	}
	
}
