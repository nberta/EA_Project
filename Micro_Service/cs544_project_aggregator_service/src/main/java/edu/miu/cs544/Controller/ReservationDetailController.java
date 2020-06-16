package edu.miu.cs544.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs544.service.ReservationDetailService;
import edu.miu.cs544.service.response.ReservationDetailResponse;

@RestController
@RequestMapping("/reservationDetails")
public class ReservationDetailController {
	@Autowired
	private ReservationDetailService reservationDetailService;
	
	@GetMapping
	public List<ReservationDetailResponse> getAll() {
		return reservationDetailService.getAll();
	}
	
	@GetMapping(params = {"reservation_code"})
	public ReservationDetailResponse[] getAllByPassengerId(@RequestParam String reservation_code) {
		return reservationDetailService.getAllByReservationCode(reservation_code);
	}
}
