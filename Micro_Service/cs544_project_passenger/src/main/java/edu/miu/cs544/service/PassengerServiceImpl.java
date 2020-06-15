package edu.miu.cs544.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.repository.PassengerRepository;
import edu.miu.cs544.service.response.PassengerResponse;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;
	
	@Override
	public PassengerResponse getById(Integer id) {
		return new PassengerResponse(passengerRepository.findById(id).get());
	}
	
	@Override
	public List<PassengerResponse> getAll() {
		return passengerRepository.findAll()
				.parallelStream()
				.map(passenger -> new PassengerResponse(passenger))
				.collect(Collectors.toList());
	}
}
