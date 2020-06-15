package edu.miu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.domain.ReservationDetail;
import edu.miu.cs544.repository.ReservationDetailRepository;

@Service
@Transactional
public class ReservationDetailServiceImpl implements ReservationDetailService {

	@Autowired
	private ReservationDetailRepository reservationDetailRepository;
	
	@Override
	public List<ReservationDetail> getAllByReservationCode(String code) {
		return reservationDetailRepository.findByReservationCode(code);
	}
}
