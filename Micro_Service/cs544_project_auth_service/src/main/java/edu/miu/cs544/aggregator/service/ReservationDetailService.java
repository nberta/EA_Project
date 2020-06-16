package edu.miu.cs544.aggregator.service;

import java.util.List;

import edu.miu.cs544.service.aggregator.response.ReservationDetailResponse;

public interface ReservationDetailService {
	List<ReservationDetailResponse> getAll();
	ReservationDetailResponse[] getAllByReservationCode(String reservation_code);
}
