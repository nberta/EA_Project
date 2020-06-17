package edu.miu.cs544.service.response;

import edu.miu.cs544.domain.ReservationDetail;

public class ReservationDetailResponse {
	private Integer id;
	private ReservationResponse reservation;
	private Integer flightNumber;
	
	public ReservationDetailResponse() {
		super();
	}
	public ReservationDetailResponse(ReservationDetail reservationDetail) {
		super();
		if(reservationDetail != null) {
			this.id = reservationDetail.getId();
			this.reservation = new ReservationResponse(reservationDetail.getReservation());
			this.flightNumber = reservationDetail.getFlightNumber();
		}
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
