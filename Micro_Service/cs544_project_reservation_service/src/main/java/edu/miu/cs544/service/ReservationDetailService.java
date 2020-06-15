package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.service.response.ReservationDetailResponse;

public interface ReservationDetailService {
	List<ReservationDetailResponse> getAllByReservationCode(String code);
}
