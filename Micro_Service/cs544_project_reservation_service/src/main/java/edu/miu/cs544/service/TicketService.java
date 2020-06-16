package edu.miu.cs544.service;

import java.util.List;

import edu.miu.cs544.service.response.TicketResponse;
import edu.miu.cs544.service.response.TicketsAndEmailScheduleRequest;

public interface TicketService {
	List<TicketResponse> purchaseTickets(String code, Integer passengerId);
}
