package edu.miu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.domain.Passenger;
import edu.miu.cs544.repository.PassengerRepository;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;
	
	@Override
	public List<Passenger> getAll() {
		return passengerRepository.findAll();
	}

	@Override
	public Passenger getById(Integer id) {
		return passengerRepository.findById(id).get();
	}
	
}
