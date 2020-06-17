package edu.miu.cs544.aggregator.service;

import java.util.List;

import edu.miu.cs544.service.aggregator.response.ReservationResponse;
import edu.miu.cs544.service.aggregator.response.ScheduleEmailResponse;

public interface ReservationService {
	ReservationResponse getByCode(String code);
	List<ReservationResponse> getAll();
	List<ReservationResponse> getAllByPassengerId(Integer id);
	ScheduleEmailResponse finalizeReservation(String code);
}
