package com.glgraded.TicketTracker.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.glgraded.TicketTracker.dto.TicketDTO;
import com.glgraded.TicketTracker.entity.Ticket;
import com.glgraded.TicketTracker.mapper.TicketMapper;
import com.glgraded.TicketTracker.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;

	public TicketServiceImpl(TicketRepository ticketRepository)
	{
		this.ticketRepository=ticketRepository;
	}

	@Override
	public List<TicketDTO> findAllTickets() {
		// TODO Auto-generated method stub
		List<Ticket> tickets=ticketRepository.findAll();
		return tickets.stream().map(TicketMapper::mapToTicketDTO).collect(Collectors.toList());
	}

	@Override
	public void createTicket(TicketDTO ticketDTO) {

		Ticket ticket=TicketMapper.mapToTicket(ticketDTO);
		ticketRepository.save(ticket);
	}

	@Override
	public TicketDTO findTicketById(Long ticketId) {
		Ticket ticket=ticketRepository.findById(ticketId).get();
		return TicketMapper.mapToTicketDTO(ticket);
	}

	@Override
	public void updateTicket(TicketDTO ticketDto) {
		Ticket ticket=TicketMapper.mapToTicket(ticketDto);
		ticketRepository.save(ticket);	
	}

	@Override
	public void deleteTicket(Long ticketId) {
		ticketRepository.deleteById(ticketId);		
	}

	@Override
	public List<TicketDTO> searchTickets(String query) {
		List<Ticket> tickets=ticketRepository.searchTickets(query);
		return tickets.stream().map(TicketMapper::mapToTicketDTO).collect(Collectors.toList());
	}

}
