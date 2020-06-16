package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.service.response.ReservationResponse;

public interface ReservationService {
	ReservationResponse getByCode(String code);
	ReservationResponse cancelReservation(String code);
	List<ReservationResponse> getAll();
	List<ReservationResponse> getAllByPassengerId(Integer id);
	List<ReservationResponse> getAllByUserEmailAndPassengerId(String userEmail, Integer passengerId);
	List<ReservationResponse> getAllByUserEmail(String userEmail);
}
