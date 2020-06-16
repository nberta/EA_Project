package edu.miu.cs544.service.response;

import java.util.Date;



public class ScheduleEmailRequest {
    private String email;
    private String firstName;
    private String lastName;
    private Integer number;
    private String airline;
    private String departureAirport;
    private String arrivalAirport;
    private Date departureDate;
    private Date arrivalDate;
    
    

    public ScheduleEmailRequest(String email, String firstName, String lastName, Integer number, String airline,
			String departureAirport, String arrivalAirport, Date departureDate, Date arrivalDate) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.airline = airline;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}

	public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
