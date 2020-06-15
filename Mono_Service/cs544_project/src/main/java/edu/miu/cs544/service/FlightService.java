package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.domain.Flight;

public interface FlightService {
	List<Flight> getAll();
	List<Flight> getAllByDepartureAirportCode(String code);
	Flight getById(Integer id);
	Flight getByNumber(Long number);
}
