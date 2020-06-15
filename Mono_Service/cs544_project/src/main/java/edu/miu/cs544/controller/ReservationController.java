package edu.miu.cs544.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.domain.Flight;
import edu.miu.cs544.domain.Reservation;
import edu.miu.cs544.service.ReservationDetailService;
import edu.miu.cs544.service.ReservationService;

@RestController
@RequestMapping("reservations")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ReservationDetailService reservationDetailService;
	
	@GetMapping
	public List<Reservation> getAll() {
		return reservationService.getAll();
	}
	
	@GetMapping(params = {"code"})
	public Reservation getByCode(@RequestParam String code) {
		return reservationService.getByCode(code);
	}
	
	@GetMapping("/{reservationCode}/flights")
	public List<Flight> getAllFlightByReservationCode(@PathVariable String reservationCode) {
		return reservationDetailService.getAllByReservationCode(reservationCode)
				.stream()
				.parallel()
				.map(detail -> detail.getFlight())
				.collect(Collectors.toList());
	}
	
}
