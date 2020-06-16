package edu.miu.cs544.service;


import java.util.List;

import edu.miu.cs544.service.response.FlightResponse;

public interface FlightService {
	FlightResponse getByNumber(Integer number);
	List<FlightResponse> getAllByNumbers(List<Integer> numbers);
	List<FlightResponse> getAll();
}
