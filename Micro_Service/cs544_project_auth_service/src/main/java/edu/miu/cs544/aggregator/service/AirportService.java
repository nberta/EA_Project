package edu.miu.cs544.aggregator.service;


import java.util.List;

import edu.miu.cs544.service.aggregator.response.AirportResponse;

public interface AirportService {
	AirportResponse getByCode(String code);
	List<AirportResponse> getAll();
}
