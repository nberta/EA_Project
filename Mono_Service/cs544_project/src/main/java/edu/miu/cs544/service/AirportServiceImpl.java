package edu.miu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.domain.Airport;
import edu.miu.cs544.repository.AirportRepository;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {
	
	@Autowired
	private AirportRepository airportRepository;
	
	@Override
	public List<Airport> getAll() {
		return airportRepository.findAll();
	}

	@Override
	public Airport getByCode(String code) {
		return airportRepository.findByCode(code);
	}
	
//	public AirportResponse convertAirportToAirportResponse(Airport airport) {
//		return new AirportResponse(airport.getId(), airport.getCode(), airport.getName(), 
//				new AddressResponse(airport.getAddress().getId(), airport.getAddress().getStreet(), airport.getAddress().getCity(), airport.getAddress().getState(), airport.getAddress().getZip()));
//	}
}
