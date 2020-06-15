package edu.miu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.domain.Flight;
import edu.miu.cs544.repository.FlightRepository;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepository flightRepository;
	
	@Override
	public List<Flight> getAll() {
		return flightRepository.findAll();
	}

	@Override
	public List<Flight> getAllByDepartureAirportCode(String code) {
		return flightRepository.findByDepartureAirportCode(code);
	}

	@Override
	public Flight getById(Integer id) {
		return flightRepository.findById(id).get();
	}

	@Override
	public Flight getByNumber(Long number) {
		return flightRepository.findByNumber(number);
	}

}
