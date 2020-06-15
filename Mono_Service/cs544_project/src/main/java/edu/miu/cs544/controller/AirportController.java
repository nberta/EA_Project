package edu.miu.cs544.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.domain.Airline;
import edu.miu.cs544.domain.Airport;
import edu.miu.cs544.domain.Flight;
import edu.miu.cs544.service.AirportService;

@RestController
@RequestMapping("/airports")
public class AirportController {
	@Autowired
	private AirportService airportService;
	
	@GetMapping
	public List<Airport> getAll() {
		return airportService.getAll();
	}
	
	@GetMapping(params = {"code"})
	public Airport getByCode(@RequestParam String code) {
		return airportService.getByCode(code);
	}
	
	@GetMapping("/{airportCode}/departureFlights")
	public List<Flight> getAllDepartureFlightByAirportCode(@PathVariable String airportCode) {
		return airportService.getByCode(airportCode).getListDepartureFlight();
	}
	
	@GetMapping("/{airportCode}/departureAirlines")
	public List<Airline> getAllDepartureAirlineByAirportCode(@PathVariable String airportCode) {
		return airportService.getByCode(airportCode).getListDepartureFlight()
				.stream()
				.parallel()
				.map(f->f.getAirline())
				.collect(Collectors.toList());
	}
}
