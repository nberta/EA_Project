package edu.miu.cs544.service;


import java.util.List;

import edu.miu.cs544.service.response.AirportResponse;

public interface AirportService {
	AirportResponse getByCode(String code);
	List<AirportResponse> getAll();
}
