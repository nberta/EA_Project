package edu.miu.cs544.service.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PassengerResponse {
	private Integer id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String email;
	private AddressResponse address;
	private List<ReservationResponse> listReservation = new ArrayList<ReservationResponse>();
	public PassengerResponse() {
		super();
	}
	
	public PassengerResponse(String firstName, String lastName, Date dateOfBirth, String email, AddressResponse address,
			List<ReservationResponse> listReservation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.address = address;
		this.listReservation = listReservation;
	}

	public PassengerResponse(Integer id, String firstName, String lastName, Date dateOfBirth, String email,
			AddressResponse address, List<ReservationResponse> listReservation) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.address = address;
		this.listReservation = listReservation;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AddressResponse getAddress() {
		return address;
	}
	public void setAddress(AddressResponse address) {
		this.address = address;
	}
	public List<ReservationResponse> getListReservation() {
		return listReservation;
	}
	public void setListReservation(List<ReservationResponse> listReservation) {
		this.listReservation = listReservation;
	}
	
	
}
