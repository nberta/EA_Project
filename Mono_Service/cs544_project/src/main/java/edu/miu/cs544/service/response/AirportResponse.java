package edu.miu.cs544.service.response;

import java.util.ArrayList;
import java.util.List;

import edu.miu.cs544.domain.Flight;

public class AirportResponse {
	private Integer id;
	private String code;
	private String name;
	private AddressResponse address;
	
	private List<Flight> listDepartureFlight = new ArrayList<Flight>();
	private List<Flight> listArrivalFlight = new ArrayList<Flight>();
	
	public AirportResponse() {
		super();
	}
	
	public AirportResponse(String code, String name, AddressResponse address) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
	}

	public AirportResponse(Integer id, String code, String name, AddressResponse address) {
		super();
		this.id = id;
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
	public AddressResponse getAddress() {
		return address;
	}
	public void setAddress(AddressResponse address) {
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
