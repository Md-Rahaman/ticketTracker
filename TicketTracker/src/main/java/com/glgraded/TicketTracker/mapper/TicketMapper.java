package com.glgraded.TicketTracker.mapper;

import com.glgraded.TicketTracker.dto.TicketDTO;
import com.glgraded.TicketTracker.entity.Ticket;

public class TicketMapper {

	public static TicketDTO mapToTicketDTO(Ticket ticket) {

		return TicketDTO.builder()
				.id(ticket.getId())
				.title(ticket.getTitle())
				.content(ticket.getContent())
				.shortDescription(ticket.getShortDescription())
				.createdOn(ticket.getCreatedOn())
				.updatedOn(ticket.getUpdatedOn())
				.build();
	}

	public static Ticket mapToTicket(TicketDTO ticketDto) {

		return Ticket.builder()
				.id(ticketDto.getId())
				.title(ticketDto.getTitle())
				.content(ticketDto.getContent())
				.shortDescription(ticketDto.getShortDescription())
				.createdOn(ticketDto.getCreatedOn())
				.updatedOn(ticketDto.getUpdatedOn())
				.build();
	}

}
