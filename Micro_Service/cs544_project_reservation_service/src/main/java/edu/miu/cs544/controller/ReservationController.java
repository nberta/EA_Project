package edu.miu.cs544.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import edu.miu.cs544.service.ReservationService;
import edu.miu.cs544.service.response.ReservationResponse;
import edu.miu.cs544.service.response.TicketResponse;
import edu.miu.cs544.service.response.TicketsAndEmailScheduleRequest;

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
	
	@GetMapping(params = {"user_email"})
	public List<ReservationResponse> getAllReservationByUserEmail(@RequestParam String user_email) {
		return reservationService.getAllByUserEmail(user_email);
	}
	
	@GetMapping(params = {"user_email", "passenger_id"})
	public List<ReservationResponse> getAllReservationByUserEmailAndPassengerId(@RequestParam String user_email, @RequestParam Integer passenger_id) {
		return reservationService.getAllByUserEmailAndPassengerId(user_email, passenger_id);
	}
	
	@DeleteMapping(params = {"code"})
	public ReservationResponse cancelReservation(@RequestParam String code) {
		return reservationService.cancelReservation(code);
	}
  
	@GetMapping("/{code}/flights")
	public List<Integer> getAllFlightByReservationCode(@PathVariable String code) {
	   return reservationService.getAllFlightsByReservationCode(code);
	}
	
	@PostMapping("/{passengerId}/reservations")
	public ReservationResponse makeReservation(@PathVariable Integer passengerId, @RequestBody List<Integer> flightNumbers){
		try {
			return reservationService.makeReservation(passengerId, flightNumbers);			
		} catch (NoSuchElementException ex){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Passenger id does not exist", ex);
			
		}
  }
    
	@PostMapping("/{code}/tickets")
	public TicketsAndEmailScheduleRequest finalizeReservation(@PathVariable String code) {
		return reservationService.finalizeReservation(code);
	}
}
