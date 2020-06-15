package edu.miu.cs544.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.repository.AirportRepository;
import edu.miu.cs544.service.response.AirportResponse;

@Service
@Transactional
public class AirportServiceImpl implements AirportService {
	
	@Autowired
	private AirportRepository airportRepository;
	
	@Override
	public AirportResponse getByCode(String code) {
		return new AirportResponse(airportRepository.findByCode(code));
	}

	@Override
	public AirportResponse getById(Integer id) {
		return new AirportResponse(airportRepository.findById(id).get());
	}
	
	@Override
	public List<AirportResponse> getAll() {
		return airportRepository.findAll()
				.parallelStream()
				.map(a -> new AirportResponse(a))
				.collect(Collectors.toList());
	}
}
