package edu.miu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.domain.Airline;
import edu.miu.cs544.repository.AirlineRepository;

@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {
	
	@Autowired
	private AirlineRepository airlineRepository;
	
	@Override
	public List<Airline> getAll() {
		return airlineRepository.findAll();
	}

	@Override
	public Airline getByCode(String code) {
		return airlineRepository.findByCode(code);
	}
	
//	public AirportResponse convertAirportToAirportResponse(Airport airport) {
//		return new AirportResponse(airport.getId(), airport.getCode(), airport.getName(), 
//				new AddressResponse(airport.getAddress().getId(), airport.getAddress().getStreet(), airport.getAddress().getCity(), airport.getAddress().getState(), airport.getAddress().getZip()));
//	}
}
