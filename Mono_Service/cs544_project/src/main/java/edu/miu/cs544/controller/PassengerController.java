package edu.miu.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.domain.Passenger;
import edu.miu.cs544.domain.Reservation;
import edu.miu.cs544.service.PassengerService;
import edu.miu.cs544.service.ReservationService;

@RestController
@RequestMapping("passengers")
public class PassengerController {
	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping
	public List<Passenger> getAll() {
		return passengerService.getAll();
	}
	
	@GetMapping("/{id}")
	public Passenger getById(@PathVariable Integer id) {
		return passengerService.getById(id);
	}
	
	@GetMapping("/{passengerId}/reservations")
	public List<Reservation> getAllReservationByPassengerId(@PathVariable Integer passengerId) {
		return reservationService.getAllByPassengerId(passengerId);
	}
	
}
