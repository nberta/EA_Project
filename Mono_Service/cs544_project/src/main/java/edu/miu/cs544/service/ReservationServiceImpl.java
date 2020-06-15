package edu.miu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.domain.Reservation;
import edu.miu.cs544.repository.ReservationRepository;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	@Override
	public List<Reservation> getAll() {
		return reservationRepository.findAll();
	}

	@Override
	public List<Reservation> getAllByPassengerId(Integer id) {
		return reservationRepository.findByPassengerId(id);
	}

	@Override
	public Reservation getByCode(String code) {
		return reservationRepository.findByCode(code);
	}
	

}
