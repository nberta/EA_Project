package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.service.response.PassengerResponse;

public interface PassengerService {
	PassengerResponse getById(Integer id);
	List<PassengerResponse> getAll();
}
