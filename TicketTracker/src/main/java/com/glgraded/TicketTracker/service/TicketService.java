package com.glgraded.TicketTracker.service;

import java.util.List;

import com.glgraded.TicketTracker.dto.TicketDTO;

public interface TicketService {

	List<TicketDTO> findAllTickets();

	public void createTicket(TicketDTO ticketDTO);	

	TicketDTO findTicketById(Long ticketId);

	void updateTicket(TicketDTO ticketDto);

	void deleteTicket(Long ticketId);

	List<TicketDTO> searchTickets(String query);

}
