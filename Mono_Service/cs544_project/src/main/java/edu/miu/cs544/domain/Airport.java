package edu.miu.cs544.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;

@Entity
public class Airport {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(length = 3)
	private String code;
	private String name;
	@OneToOne
	@JoinColumn
	private Address address;
	@OneToMany(mappedBy = "departureAirport")
	@OrderColumn(name="sequence")
	private List<Flight> listDepartureFlight = new ArrayList<Flight>();
	@OneToMany(mappedBy = "arrivalAirport")
	@OrderColumn(name="sequence")
	private List<Flight> listArrivalFlight = new ArrayList<Flight>();
	
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

	public List<Flight> getListDepartureFlight() {
		return listDepartureFlight;
	}

	public void setListDepartureFlight(List<Flight> listDepartureFlight) {
		this.listDepartureFlight = listDepartureFlight;
	}

	public List<Flight> getListArrivalFlight() {
		return listArrivalFlight;
	}

	public void setListArrivalFlight(List<Flight> listArrivalFlight) {
		this.listArrivalFlight = listArrivalFlight;
	}
	
	
	
}
