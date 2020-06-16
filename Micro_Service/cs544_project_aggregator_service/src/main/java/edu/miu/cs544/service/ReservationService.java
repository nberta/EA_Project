package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.service.response.ReservationResponse;
import edu.miu.cs544.service.response.ScheduleEmailResponse;
import edu.miu.cs544.service.response.TicketsAndEmailScheduleRequest;

public interface ReservationService {
	ReservationResponse getByCode(String code);
	List<ReservationResponse> getAll();
	List<ReservationResponse> getAllByPassengerId(Integer id);
	ScheduleEmailResponse finalizeReservation(String code);
}
