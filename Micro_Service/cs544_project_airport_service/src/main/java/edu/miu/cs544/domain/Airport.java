package edu.miu.cs544.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Airport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 3, unique = true)
	private String code;
	
	private String name;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn
	private Address address;
	
	@OneToMany(mappedBy = "departureAirport", cascade = CascadeType.REMOVE)
	private List<Flight> departureFlights = new ArrayList<Flight>();
	
	@OneToMany(mappedBy = "arrivalAirport", cascade = CascadeType.REMOVE)
	private List<Flight> arrivalFlights = new ArrayList<Flight>();
	
	public Airport() {
		super();
	}
	
	public Airport(String code, String name, Address address) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Flight> getDepartureFlights() {
		return Collections.unmodifiableList(departureFlights);
	}

	public void setDepartureFlights(List<Flight> departureFlights) {
		this.departureFlights = departureFlights;
	}

	public List<Flight> getArrivalFlights() {
		return Collections.unmodifiableList(arrivalFlights);
	}

	public void setArrivalFlights(List<Flight> arrivalFlights) {
		this.arrivalFlights = arrivalFlights;
	}
	
	
	public boolean addArrivalFlight(Flight flight) {
		boolean success = false;
		if (arrivalFlights.add(flight)) {
			flight.setArrivalAirport(this);
			success = true;
		}
		return success;
	}

	public boolean removeArrivalFlight(Flight flight) {
		boolean success = false;
		if (arrivalFlights.remove(flight)) {
			flight.setArrivalAirport(null);
			success = true;
		}
		return success;
	}

	public boolean addDepartureFlight(Flight flight) {
		boolean success = false;
		if (departureFlights.add(flight)) {
			flight.setDepartureAirport(this);
			success = true;
		}
		return success;
	}

	public boolean removeDepartureFlight(Flight flight) {
		boolean success = false;
		if (departureFlights.remove(flight)) {
			flight.setDepartureAirport(null);
			success = true;
		}
		return success;
	}
	
	
	
}