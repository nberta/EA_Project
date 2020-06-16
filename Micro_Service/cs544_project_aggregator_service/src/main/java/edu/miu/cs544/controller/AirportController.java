package edu.miu.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.service.AirportService;
import edu.miu.cs544.service.response.AirportResponse;

@RestController
@RequestMapping("/airports")
public class AirportController {
	@Autowired
	private AirportService airportService;
	
	@GetMapping
	public List<AirportResponse> getAll() {
		return airportService.getAll();
	}
	
	@GetMapping(params = {"code"})
	public AirportResponse getByCode(@RequestParam String code) {
		return airportService.getByCode(code);
	}
}
