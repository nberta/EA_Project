package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.domain.Reservation;

public interface ReservationService {
	List<Reservation>  getAll();
	
	List<Reservation>  getAllByPassengerId(Integer id);
	
	Reservation getByCode(String code);

}
