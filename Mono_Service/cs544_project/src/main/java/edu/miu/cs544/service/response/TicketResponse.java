package edu.miu.cs544.service.response;

public class TicketResponse {
	private Integer id;
	private Long number;
	private ReservationDetailResponse ReservationDetail;
	public TicketResponse() {
		super();
	}
	
	public TicketResponse(Long number, ReservationDetailResponse reservationDetail) {
		super();
		this.number = number;
		ReservationDetail = reservationDetail;
	}

	public TicketResponse(Integer id, Long number, edu.miu.cs544.service.response.ReservationDetailResponse reservationDetail) {
		super();
		this.id = id;
		this.number = number;
		ReservationDetail = reservationDetail;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public ReservationDetailResponse getReservationDetail() {
		return ReservationDetail;
	}
	public void setReservationDetail(ReservationDetailResponse reservationDetail) {
		ReservationDetail = reservationDetail;
	}
	
	
}
