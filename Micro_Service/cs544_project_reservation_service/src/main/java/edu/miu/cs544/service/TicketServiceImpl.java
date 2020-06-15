package edu.miu.cs544.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs544.domain.Reservation;
import edu.miu.cs544.domain.Ticket;
import edu.miu.cs544.repository.ReservationRepository;
import edu.miu.cs544.repository.TicketRepository;
import edu.miu.cs544.service.response.TicketResponse;
import edu.miu.cs544.util.Constant.ReservationStatus;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	private ReservationRepository reservationRepository;
	
	public Long makeTicketNumber() {
		Long ticketNumber = Math.round(Math.random() * Math.pow(10, 20));
		if (ticketNumber < Math.pow(10, 20)) makeTicketNumber();
		Ticket ticket = ticketRepository.findByNumber(ticketNumber);
		if (ticket != null) {
			makeTicketNumber();
		}
		return ticketNumber;	
	}
	
	public List<Ticket> saveAll(List<Ticket> tickets) {
		tickets = ticketRepository.saveAll(tickets);
		return tickets;
	}
	
	@Override
	public List<TicketResponse> purchaseReservation(String code, Integer passengerId) {
		Reservation reservation = reservationRepository.findByCode(code);
		if(reservation == null) {
			throw new RuntimeException();
		}
		ReservationStatus status = reservation.getReservationStatus();
		if(status == ReservationStatus.CANCELLED) {
			throw new RuntimeException();
		}
		if(status == ReservationStatus.CONFIRMED) {
			throw new RuntimeException();
		}
		
		List<Ticket> tickets = reservation.getReservationDetails().stream()
								.map(detail -> new Ticket(makeTicketNumber(), detail))
								.collect(Collectors.toList());
		
		reservation.setReservationStatus(ReservationStatus.CONFIRMED);
		
		//save
		ticketRepository.saveAll(tickets);
		reservationRepository.save(reservation);
		
		return tickets.parallelStream()
				.map(ticket -> new TicketResponse(ticket))
				.collect(Collectors.toList());
	}
}
