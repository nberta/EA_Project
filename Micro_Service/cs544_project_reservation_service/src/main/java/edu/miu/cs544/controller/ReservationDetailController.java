package edu.miu.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.service.ReservationDetailService;
import edu.miu.cs544.service.response.ReservationDetailResponse;

@RestController
@RequestMapping("/reservations/details")
public class ReservationDetailController {
	@Autowired
	private ReservationDetailService reservationDetailService;
	
	@GetMapping
	public ResponseEntity<List<ReservationDetailResponse>> getAll() {
		return ResponseEntity.ok(reservationDetailService.getAll());
	}
	
	@GetMapping(params = "reservation_code")
	public ResponseEntity<List<ReservationDetailResponse>> getAllByReservationCode(String reservation_code) {
		return ResponseEntity.ok(reservationDetailService.getAllByReservationCode(reservation_code));
	}
	
}
