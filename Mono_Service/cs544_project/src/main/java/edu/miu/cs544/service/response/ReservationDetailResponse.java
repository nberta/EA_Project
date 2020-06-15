package edu.miu.cs544.service.response;

public class ReservationDetailResponse {
	private Integer id;
	private ReservationResponse reservation;
	private FlightResponse flight;
	public ReservationDetailResponse() {
		super();
	}
	
	public ReservationDetailResponse(ReservationResponse reservation, FlightResponse flight) {
		super();
		this.reservation = reservation;
		this.flight = flight;
	}

	public ReservationDetailResponse(Integer id, ReservationResponse reservation, FlightResponse flight) {
		super();
		this.id = id;
		this.reservation = reservation;
		this.flight = flight;
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
	public FlightResponse getFlight() {
		return flight;
	}
	public void setFlight(FlightResponse flight) {
		this.flight = flight;
	} 
	
	
}
