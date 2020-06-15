package edu.miu.cs544.service.response;

import java.util.ArrayList;
import java.util.List;

public class ReservationResponse {
	private Integer id;
	private String code;
	private PassengerResponse passenger;
	private List<ReservationDetailResponse> listReservationDetail = new ArrayList<ReservationDetailResponse>();
	public ReservationResponse() {
		super();
	}
	
	public ReservationResponse(String code, PassengerResponse passenger, List<ReservationDetailResponse> listReservationDetail) {
		super();
		this.code = code;
		this.passenger = passenger;
		this.listReservationDetail = listReservationDetail;
	}

	public ReservationResponse(Integer id, PassengerResponse passenger, List<ReservationDetailResponse> listReservationDetail) {
		super();
		this.id = id;
		this.passenger = passenger;
		this.listReservationDetail = listReservationDetail;
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

	public PassengerResponse getPassenger() {
		return passenger;
	}
	public void setPassenger(PassengerResponse passenger) {
		this.passenger = passenger;
	}
	public List<ReservationDetailResponse> getListReservationDetail() {
		return listReservationDetail;
	}
	public void setListReservationDetail(List<ReservationDetailResponse> listReservationDetail) {
		this.listReservationDetail = listReservationDetail;
	}
	
	
}
