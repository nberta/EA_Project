package edu.miu.cs544.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs544.domain.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
	Flight findByNumber(Integer number);
	List<Flight> findByDepartureAirportCode(String code);
//	List<Flight> findByDepartureAirportCodeAndArrivalAirportCodeAndDepartureDate(String departureAirportCode, String arrivalAirportCode, Date departureDate);
}
