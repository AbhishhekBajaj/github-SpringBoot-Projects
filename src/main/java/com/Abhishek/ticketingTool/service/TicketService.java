package com.Abhishek.ticketingTool.service;

import com.Abhishek.ticketingTool.dto.CreateTicketRequest;
import com.Abhishek.ticketingTool.dto.TicketResponse;
import com.Abhishek.ticketingTool.entity.TicketStatus;
import lombok.AllArgsConstructor;

import java.util.List;


public interface TicketService {

    List<TicketResponse> getAll();
    TicketResponse createTicket(CreateTicketRequest request);
    TicketResponse updateStatus(Long id, TicketStatus status);

    List<TicketResponse> getTicketByStatus(TicketStatus status);

}
