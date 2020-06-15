package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.service.response.ReservationResponse;

public interface ReservationService {
	ReservationResponse getByCode(String code);
	ReservationResponse cancelReservation(String code);
	List<ReservationResponse>  getAll();
	List<ReservationResponse>  getAllByPassengerId(Integer id);
}
