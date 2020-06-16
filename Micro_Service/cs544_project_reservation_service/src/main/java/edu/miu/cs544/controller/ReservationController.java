package edu.miu.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.service.ReservationService;
import edu.miu.cs544.service.response.ReservationResponse;

@RestController
@RequestMapping("reservations")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping
	public List<ReservationResponse> getAll() {
		return reservationService.getAll();
	}
	
	@GetMapping(params = {"code"})
	public ReservationResponse getByCode(@RequestParam String code) {
		return reservationService.getByCode(code);
	}
	
	@GetMapping(params = {"passenger_id"})
	public List<ReservationResponse> getAllReservationByPassengerId(@RequestParam Integer passenger_id) {
		return reservationService.getAllByPassengerId(passenger_id);
	}
	
	@GetMapping
	public List<ReservationResponse> getAllReservationByUserEmail(@RequestParam String user_email) {
		return reservationService.getAllByUserEmail(user_email);
	}
	
	@GetMapping
	public List<ReservationResponse> getAllReservationByUserEmailAndPassengerId(@RequestParam String user_email, @RequestParam Integer passenger_id) {
		return reservationService.getAllByUserEmailAndPassengerId(user_email, passenger_id);
	}
	
	@DeleteMapping(params = {"code"})
	public ReservationResponse cancelReservation(@RequestParam String code) {
		return reservationService.cancelReservation(code);
	}
}
