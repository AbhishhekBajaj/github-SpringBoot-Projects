package com.Abhishek.ticketingTool.repository;

import com.Abhishek.ticketingTool.entity.Priority;
import com.Abhishek.ticketingTool.entity.Ticket;
import com.Abhishek.ticketingTool.entity.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    List<Ticket> findByStatus (TicketStatus status);

    List<Ticket> findByPriority(Priority priority);
}
