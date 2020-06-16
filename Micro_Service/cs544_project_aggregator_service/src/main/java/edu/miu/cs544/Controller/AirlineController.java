package edu.miu.cs544.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.service.AirlineService;
import edu.miu.cs544.service.response.AirlineResponse;

@RestController
@RequestMapping("/airlines")
public class AirlineController {
	@Autowired
	private AirlineService airlineService;
	
	@GetMapping
	public List<AirlineResponse> getAll() {
		return airlineService.getAll();
	}
	
	@GetMapping(params = {"code"})
	public AirlineResponse getByCode(@RequestParam String code) {
		return airlineService.getByCode(code);
	}
	
	@GetMapping(params = {"departure_airport_code"})
	public List<AirlineResponse> getByDepartureAirportCode(@RequestParam String departure_airport_code) {
		return airlineService.getAllByDepartureAirportCode(departure_airport_code);
	}
}
