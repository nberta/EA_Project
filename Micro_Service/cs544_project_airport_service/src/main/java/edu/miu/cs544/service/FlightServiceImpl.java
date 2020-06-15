package edu.miu.cs544.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.repository.FlightRepository;
import edu.miu.cs544.service.response.FlightResponse;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightRepository flightRepository;
	
	@Override
	public FlightResponse getById(Integer id) {
		return new FlightResponse(flightRepository.findById(id).get());
	}

	@Override
	public FlightResponse getByNumber(Integer number) {
		return new FlightResponse(flightRepository.findByNumber(number));
	}
	
	@Override
	public List<FlightResponse> getAll() {
		return flightRepository.findAll()
				.stream()
				.parallel()
				.map(f->new FlightResponse(f))
				.collect(Collectors.toList());
	}

	@Override
	public List<FlightResponse> getAllByDepartureAirportCode(String code) {
		return flightRepository.findByDepartureAirportCode(code)
				.stream()
				.parallel()
				.map(f->new FlightResponse(f))
				.collect(Collectors.toList());
	}
}
