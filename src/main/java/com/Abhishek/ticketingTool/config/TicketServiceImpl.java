package com.Abhishek.ticketingTool.config;

import com.Abhishek.ticketingTool.dto.CreateTicketRequest;
import com.Abhishek.ticketingTool.dto.TicketResponse;
import com.Abhishek.ticketingTool.entity.Ticket;
import com.Abhishek.ticketingTool.entity.TicketStatus;
import com.Abhishek.ticketingTool.repository.TicketRepository;
import com.Abhishek.ticketingTool.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public List<TicketResponse> getAll(){
        return ticketRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public TicketResponse createTicket(CreateTicketRequest request){
        Ticket ticket=new Ticket();
        ticket.setTitle(request.getTitle());
        ticket.setDescription(request.getDescription());
        ticket.setPriority(request.getPriority());
        ticket.setStatus(TicketStatus.OPEN);
        ticket.setCreatedAt(LocalDateTime.now());

        Ticket saved=ticketRepository.save(ticket);
        
        return mapToResponse(saved);
    }

    @Override
    public TicketResponse updateStatus(Long id, TicketStatus status){
        Ticket ticket=ticketRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Ticket not found"));
        ticket.setStatus(status);
        ticket.setUpdatedAt(LocalDateTime.now());

        return mapToResponse(ticketRepository.save(ticket));
    }
    @Override
    public List<TicketResponse> getTicketByStatus(TicketStatus status){
        return ticketRepository.findByStatus(status)
                .stream()
                .map(this::mapToResponse)
                .toList();

    }

    private TicketResponse mapToResponse(Ticket ticket) {
        return new TicketResponse(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getStatus().name(),
                ticket.getPriority().name());
    }
}
