package edu.miu.cs544.service.aggregator.response;

public class ReservationDetailResponse {
	private Integer id;
	private ReservationResponse reservation;
	private Integer flightNumber;
	
	public ReservationDetailResponse() {
		super();
	}
	
	public ReservationDetailResponse(Integer id, ReservationResponse reservation, Integer flightNumber) {
		super();
		this.id = id;
		this.reservation = reservation;
		this.flightNumber = flightNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ReservationResponse getReservation() {
		return reservation;
	}
	public void setReservation(ReservationResponse reservation) {
		this.reservation = reservation;
	}
	public Integer getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(Integer flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	
	
}
