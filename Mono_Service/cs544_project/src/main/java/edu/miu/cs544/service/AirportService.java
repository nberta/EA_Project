package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.domain.Airport;

public interface AirportService {
	List<Airport> getAll();
	
	Airport getByCode(String code);
}
