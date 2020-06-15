package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.domain.Airline;

public interface AirlineService {
	List<Airline> getAll();
	
	Airline getByCode(String code);
}
