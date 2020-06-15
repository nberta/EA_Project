package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.service.response.AirlineResponse;

public interface AirlineService {
	AirlineResponse getById(Integer id);
	AirlineResponse getByCode(String code);
	List<AirlineResponse> getAll();
	List<AirlineResponse> getAllByDepartureAirportCode(String code);
}
