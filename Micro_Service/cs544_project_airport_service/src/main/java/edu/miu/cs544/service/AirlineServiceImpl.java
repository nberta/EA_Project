package edu.miu.cs544.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.repository.AirlineRepository;
import edu.miu.cs544.service.response.AirlineResponse;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	@Autowired
	private FlightService flightService;

	@Override
	public AirlineResponse getById(Integer id) {
		return new AirlineResponse(airlineRepository.findById(id).get());
	}
	
	@Override
	public AirlineResponse getByCode(String code) {
		return new AirlineResponse(airlineRepository.findByCode(code));
	}
	
	@Override
	public List<AirlineResponse> getAll() {
		return airlineRepository.findAll()
				.parallelStream()
				.map(airline -> new AirlineResponse(airline))
				.collect(Collectors.toList());
	}

	@Override
	public List<AirlineResponse> getAllByDepartureAirportCode(String code) {
		return flightService.getAllByDepartureAirportCode(code)
				.parallelStream()
				.map(flight -> flight.getAirline())
				.collect(Collectors.toList());
	}
}
