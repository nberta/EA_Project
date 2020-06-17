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
<<<<<<< Updated upstream
import edu.miu.cs544.service.response.TicketResponseAndEmailScheduleRequest;
=======
import edu.miu.cs544.service.response.TicketsAndEmailScheduleRequest;
>>>>>>> Stashed changes

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
	
<<<<<<< Updated upstream
	@GetMapping("/passenger/{id}")
	public List<ReservationResponse> getAllReservationByPassengerId(@PathVariable Integer id) {
		return reservationService.getAllByPassengerId(id);
		
	}
	
	@GetMapping("/email/{email}")
	public List<ReservationResponse> getAllReservationByUserEmail(@PathVariable String email) {
		return reservationService.getAllByUserEmail(email);
=======
	@GetMapping
	public ReservationResponse getByCodeAndPassengerId(@RequestParam String code, @RequestParam Integer passenger_id) {
		return reservationService.getByCodeAndPassengerId(code, passenger_id);
	}
	
	@GetMapping
	public ReservationResponse getByCodeAndUserEmail(@RequestParam String code, @RequestParam String user_email) {
		return reservationService.getByCodeAndUserEmail(code, user_email);
	}
	
	@GetMapping(params = {"passenger_id"})
	public List<ReservationResponse> getAllReservationByPassengerId(@RequestParam Integer passenger_id) {
		return reservationService.getAllByPassengerId(passenger_id);
	}
	
	@GetMapping(params = {"user_email"})
	public List<ReservationResponse> getAllByUserEmail(@RequestParam String user_email) {
		return reservationService.getAllByUserEmail(user_email);
	}
	
	@GetMapping(params = {"user_email", "passenger_id"})
	public List<ReservationResponse> getAllByUserEmailAndPassengerId(@RequestParam String user_email, @RequestParam Integer passenger_id) {
		return reservationService.getAllByUserEmailAndPassengerId(user_email, passenger_id);
>>>>>>> Stashed changes
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
