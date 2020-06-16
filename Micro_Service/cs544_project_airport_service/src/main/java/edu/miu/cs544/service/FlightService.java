package edu.miu.cs544.service;

import java.util.Collection;
import java.util.List;

import edu.miu.cs544.service.request.FlightRequest;
import edu.miu.cs544.service.response.FlightResponse;

public interface FlightService {
	FlightResponse getById(Integer id);
	FlightResponse getByNumber(Integer number);
	List<FlightResponse> getAll();
	List<FlightResponse> getAllByNumbers(List<Integer> numbers);
	List<FlightResponse> getAllByDepartureAirportCode(String code);
	Collection<FlightResponse> saveAll(Collection<FlightRequest> flights);
	FlightResponse put(FlightRequest flightRequest, Integer flightNumber);
	FlightResponse deleteFlight(Integer flightNumber);
}
