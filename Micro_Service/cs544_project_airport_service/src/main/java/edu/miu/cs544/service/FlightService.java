package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.service.response.FlightResponse;

public interface FlightService {
	FlightResponse getById(Integer id);
	FlightResponse getByNumber(Integer number);
	List<FlightResponse> getAll();
	List<FlightResponse> getAllByDepartureAirportCode(String code);
}
