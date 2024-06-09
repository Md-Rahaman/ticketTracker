package com.glgraded.TicketTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.glgraded.TicketTracker.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

	@Query("SELECT p from Ticket p WHERE " +
			" p.title LIKE CONCAT('%', :query, '%') OR " +
			" p.shortDescription LIKE CONCAT('%', :query, '%')")
	List<Ticket> searchTickets(String query);


}
