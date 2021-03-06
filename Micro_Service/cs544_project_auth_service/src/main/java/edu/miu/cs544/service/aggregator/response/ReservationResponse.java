package edu.miu.cs544.service.aggregator.response;

import edu.miu.cs544.util.Constant.ReservationStatus;

public class ReservationResponse {
	private Integer id;
	private String code;
	private ReservationStatus reservationStatus;
	private PassengerResponse passenger;
	private String userEmail;
	
	public ReservationResponse() {
		super();
	}

	public ReservationResponse(Integer id, String code, ReservationStatus reservationStatus,
			PassengerResponse passenger, String userEmail) {
		super();
		this.id = id;
		this.code = code;
		this.reservationStatus = reservationStatus;
		this.passenger = passenger;
		this.userEmail = userEmail;
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

	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public PassengerResponse getPassenger() {
		return passenger;
	}

	public void setPassenger(PassengerResponse passenger) {
		this.passenger = passenger;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
}
