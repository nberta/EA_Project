package edu.miu.cs544.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Ticket {
	@Id
	@GeneratedValue
	private Integer id;
	private Long number;
	@OneToOne
	@JoinColumn
	private ReservationDetail ReservationDetail;
	public Ticket() {
		super();
	}
	
	public Ticket(Long number, ReservationDetail reservationDetail) {
		super();
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
	public ReservationDetail getReservationDetail() {
		return ReservationDetail;
	}
	public void setReservationDetail(ReservationDetail reservationDetail) {
		ReservationDetail = reservationDetail;
	}
	
	
}
