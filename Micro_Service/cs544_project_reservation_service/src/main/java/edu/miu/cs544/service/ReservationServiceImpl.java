package edu.miu.cs544.service;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.domain.Passenger;
import edu.miu.cs544.domain.Reservation;
import edu.miu.cs544.domain.ReservationDetail;
import edu.miu.cs544.repository.PassengerRepository;
import edu.miu.cs544.repository.ReservationRepository;
import edu.miu.cs544.service.response.ReservationResponse;
import edu.miu.cs544.util.Constant.ReservationStatus;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ReservationDetailService reservationDetailService;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Override
	public ReservationResponse getByCode(String code) {
		return new ReservationResponse(reservationRepository.findByCode(code));
	}

	@Override
	public ReservationResponse cancelReservation(String code) {
		Reservation reservation = reservationRepository.findByCode(code);
		if(reservation.getReservationStatus() == ReservationStatus.CONFIRMED) {
			throw new RuntimeException("Cannot cancel a confirmed reservation.");
		}
		reservation.setReservationStatus(ReservationStatus.CANCELLED);;
		reservationRepository.save(reservation);
		return new ReservationResponse(reservation);
	}
	
	@Override
	public List<ReservationResponse> getAll() {
		return reservationRepository.findAll()
				.parallelStream()
				.map(reservation -> new ReservationResponse(reservation))
				.collect(Collectors.toList());
	}

	@Override
	public List<ReservationResponse> getAllByPassengerId(Integer id) {
		return reservationRepository.findByPassengerId(id)
				.parallelStream()
				.map(reservation -> new ReservationResponse(reservation))
				.collect(Collectors.toList());
	}

	@Override
	public List<ReservationResponse> getAllByUserEmail(String userEmail) {
		return reservationRepository.findByUserEmail(userEmail)
				.parallelStream()
				.map(reservation -> new ReservationResponse(reservation))
				.collect(Collectors.toList());
	}

	@Override
	public List<ReservationResponse> getAllByUserEmailAndPassengerId(String userEmail, Integer passengerId) {
		return reservationRepository.findByUserEmailAndPassengerId(userEmail, passengerId)
				.parallelStream()
				.map(reservation -> new ReservationResponse(reservation))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Integer> getAllFlightsByReservationCode(String code) {
		return reservationDetailService.getAllByReservationCode(code)
		         .stream()
		         .parallel()
		         .map(detail -> detail.getFlightNumber())
		         .collect(Collectors.toList());
	}
		
	@Override
	public ReservationResponse makeReservation(Integer passengerId, List<Integer> flights) {
		Passenger passenger = passengerRepository.findById(passengerId).get();
	    String reservationCode = UUID.randomUUID().toString().substring(0,6).toUpperCase();
	    Reservation reservation = new Reservation();
	    List<ReservationDetail> rdetails =
	            flights.stream().map(f-> new ReservationDetail(reservation,f)).collect(Collectors.toList());
	    reservation.setCode(reservationCode);
	    reservation.setPassenger(passenger);
	    reservation.setReservationDetails(rdetails);
	    reservationRepository.save(reservation);
	    return new ReservationResponse(reservation);
	}	
}
