package edu.miu.cs544.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.repository.ReservationDetailRepository;
import edu.miu.cs544.service.response.ReservationDetailResponse;

@Service
@Transactional
public class ReservationDetailServiceImpl implements ReservationDetailService {

	@Autowired
	private ReservationDetailRepository reservationDetailRepository;
	
	@Override
	public List<ReservationDetailResponse> getAllByReservationCode(String code) {
		return reservationDetailRepository.findByReservationCode(code)
				.parallelStream()
				.map(detail -> new ReservationDetailResponse(detail))
				.collect(Collectors.toList());
	}
}
