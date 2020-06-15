package edu.miu.cs544.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReservationDetail {
	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	@JoinColumn
	private Reservation reservation;
	@ManyToOne
	@JoinColumn
	private Flight flight;
	public ReservationDetail() {
		super();
	}
	
	public ReservationDetail(Reservation reservation, Flight flight) {
		super();
		this.reservation = reservation;
		this.flight = flight;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	} 
	
	
}
