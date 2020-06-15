package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.domain.ReservationDetail;

public interface ReservationDetailService {
	List<ReservationDetail> getAllByReservationCode(String code);
}
