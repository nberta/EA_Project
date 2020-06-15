package edu.miu.cs544.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Reservation {
	@Id
	@GeneratedValue
	private Integer id;
	private String code;
	@ManyToOne
	@JoinColumn
	private Passenger passenger;
	@OneToMany(mappedBy = "reservation")
	@OrderColumn(name="sequence")
	private List<ReservationDetail> listReservationDetail = new ArrayList<ReservationDetail>();
	public Reservation() {
		super();
	}
	
	public Reservation(String code, Passenger passenger, List<ReservationDetail> listReservationDetail) {
		super();
		this.code = code;
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

	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public List<ReservationDetail> getListReservationDetail() {
		return listReservationDetail;
	}
	public void setListReservationDetail(List<ReservationDetail> listReservationDetail) {
		this.listReservationDetail = listReservationDetail;
	}
	
	
}
