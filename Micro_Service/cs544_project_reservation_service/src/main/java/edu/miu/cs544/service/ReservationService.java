package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.service.response.ReservationResponse;
<<<<<<< Updated upstream
import edu.miu.cs544.service.response.TicketResponseAndEmailScheduleRequest;
=======
import edu.miu.cs544.service.response.TicketsAndEmailScheduleRequest;
>>>>>>> Stashed changes

public interface ReservationService {
	ReservationResponse getByCode(String code);
	ReservationResponse getByCodeAndPassengerId(String code, Integer passenger_id);
	ReservationResponse getByCodeAndUserEmail(String code, String user_email);
	ReservationResponse cancelReservation(String code);
	List<ReservationResponse> getAll();
	List<ReservationResponse> getAllByPassengerId(Integer id);
	List<ReservationResponse> getAllByUserEmailAndPassengerId(String userEmail, Integer passengerId);
	List<ReservationResponse> getAllByUserEmail(String userEmail);
	ReservationResponse makeReservation(Integer passengerId, List<Integer> flights);
	List<Integer> getAllFlightsByReservationCode(String code);
<<<<<<< Updated upstream
	TicketResponseAndEmailScheduleRequest finalizeReservation(String code);
=======
	TicketsAndEmailScheduleRequest finalizeReservation(String code);
>>>>>>> Stashed changes
}
