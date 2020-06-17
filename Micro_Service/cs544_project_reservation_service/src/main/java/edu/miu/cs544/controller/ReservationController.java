package edu.miu.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.service.ReservationService;
import edu.miu.cs544.service.response.ReservationResponse;
import edu.miu.cs544.service.response.TicketResponseAndEmailScheduleRequest;

@RestController
@RequestMapping("reservations")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
		
	@GetMapping
	public List<ReservationResponse> getAll() {
		return reservationService.getAll();
	}
	
	@GetMapping("/{code}")
	public ReservationResponse getByCode(@PathVariable String code) {
		return reservationService.getByCode(code);
	}
	
	@GetMapping("/passenger/{id}")
	public List<ReservationResponse> getAllReservationByPassengerId(@PathVariable Integer id) {
		return reservationService.getAllByPassengerId(id);
		
	}
	
	@GetMapping("/email/{email}")
	public List<ReservationResponse> getAllReservationByUserEmail(@PathVariable String email) {
		return reservationService.getAllByUserEmail(email);
	}
	
	@DeleteMapping("/{code}")
	public ReservationResponse cancelReservation(@PathVariable String code) {
		return reservationService.cancelReservation(code);
	}
  
	@GetMapping("/{code}/flights")
	public List<Integer> getAllFlightByReservationCode(@PathVariable String code) {
	   return reservationService.getAllFlightsByReservationCode(code);
	}
	
	@PostMapping("/passenger/{id}")
	public ReservationResponse makeReservation(@PathVariable Integer id, @RequestBody List<Integer> flightNumbers){
		return reservationService.makeReservation(id, flightNumbers);			
	}
    
	@PostMapping("/{code}/tickets")
	public TicketResponseAndEmailScheduleRequest finalizeReservation(@PathVariable String code) {
		return reservationService.finalizeReservation(code);
	}
}
