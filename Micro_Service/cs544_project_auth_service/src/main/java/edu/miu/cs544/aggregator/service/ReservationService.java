package edu.miu.cs544.aggregator.service;

import java.util.List;

import edu.miu.cs544.service.aggregator.response.FlightResponse;
import edu.miu.cs544.service.aggregator.response.ReservationResponse;
import edu.miu.cs544.service.aggregator.response.ScheduleEmailResponse;

public interface ReservationService {
	ReservationResponse getByCode(String code);
	ReservationResponse getByCodeAndPassengerId(String code, Integer passenger_id);
	ReservationResponse getByCodeAndUserEmail(String code, String user_email);	
	List<ReservationResponse> getAll();
	List<ReservationResponse> getAllByPassengerId(Integer id);
	List<ReservationResponse> getAllByUserEmail(String user_email);
	List<ReservationResponse> getAllByUserEmailAndPassengerId(String user_email, Integer passenger_id);
	ScheduleEmailResponse finalizeReservation(String code);
	ReservationResponse makeReservation(Integer id, List<Integer> flightNumbers);
	List<ReservationResponse> getAllByUserEmail(String email);
	ReservationResponse cancelReservation(String code);
	List<FlightResponse> getAllFlightsByReservationCode(String code);
}
