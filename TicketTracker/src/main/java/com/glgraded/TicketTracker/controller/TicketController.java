package com.glgraded.TicketTracker.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glgraded.TicketTracker.dto.TicketDTO;
import com.glgraded.TicketTracker.service.TicketService;

@Controller
public class TicketController {
	private TicketService ticketService;

	public TicketController(TicketService ticketServ)
	{
		this.ticketService=ticketServ;
	}

	@GetMapping("/tickets")
	public String tickets(Model model)
	{
		List<TicketDTO> tickets=ticketService.findAllTickets();
		model.addAttribute("tickets", tickets);
		return "tickets";
	}

	@GetMapping("tickets/newTicket")
	public String newTicketForm(Model model) {
		TicketDTO ticketDTO=new TicketDTO();
		model.addAttribute("ticket",ticketDTO);
		return "createTicket";
	}

	@PostMapping("/tickets")
	public String createTicket(@ModelAttribute("ticket") TicketDTO ticketDto,Model model) {
		ticketService.createTicket(ticketDto);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/{ticketId}/edit")
	public String editTicketForm(@PathVariable("ticketId") Long ticketId, Model model) {
		TicketDTO ticketDto = ticketService.findTicketById(ticketId);
		model.addAttribute("ticket", ticketDto);
		return "edit";
	}

	@PostMapping("/tickets/{ticketId}")
	public String updateTicket(@PathVariable("ticketId") long ticketId,@ModelAttribute("ticket") TicketDTO ticket,Model model) {
		ticket.setId(ticketId);
		ticketService.updateTicket(ticket);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/{ticketId}/delete")

	public String deleteTicket(@PathVariable("ticketId") Long ticketId) {
		ticketService.deleteTicket(ticketId);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/{ticketId}/view")
	public String viewTicket(@PathVariable("ticketId") Long ticketId, Model model) {
		TicketDTO ticketDto = ticketService.findTicketById(ticketId);
		model.addAttribute("ticket", ticketDto);
		return "view";
	}

	@GetMapping("/tickets/search")
	public String searchTickets(@RequestParam(value = "query") String query, Model model) {
		List<TicketDTO> tickets = ticketService.searchTickets(query);
		model.addAttribute("tickets", tickets);
		return "tickets";

	}

}
