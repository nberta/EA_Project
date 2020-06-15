package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.domain.Passenger;

public interface PassengerService {
	List<Passenger> getAll();
	
	Passenger getById(Integer id);
}
