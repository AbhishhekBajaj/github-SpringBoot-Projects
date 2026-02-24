package com.Abhishek.ticketingTool.controller;

import com.Abhishek.ticketingTool.dto.CreateTicketRequest;
import com.Abhishek.ticketingTool.dto.TicketResponse;
import com.Abhishek.ticketingTool.entity.Ticket;
import com.Abhishek.ticketingTool.entity.TicketStatus;
import com.Abhishek.ticketingTool.repository.TicketRepository;
import com.Abhishek.ticketingTool.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("/all")
    public ResponseEntity<List<TicketResponse>> getAllTickets(){
        return ResponseEntity.ok(ticketService.getAll());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TicketResponse> createTicket(@Valid @RequestBody CreateTicketRequest request){
        return ResponseEntity.ok(ticketService.createTicket(request));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TicketResponse> updateStatus(@PathVariable Long id, @RequestParam TicketStatus status){
        return ResponseEntity.ok(ticketService.updateStatus(id,status));
    }

    @GetMapping
    public ResponseEntity<List<TicketResponse>> ticketByStatus(@RequestParam TicketStatus status){
        return ResponseEntity.ok(ticketService.getTicketByStatus(status));
    }
}
