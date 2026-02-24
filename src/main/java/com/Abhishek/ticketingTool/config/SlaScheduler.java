package com.Abhishek.ticketingTool.config;

import com.Abhishek.ticketingTool.entity.Ticket;
import com.Abhishek.ticketingTool.entity.TicketStatus;
import com.Abhishek.ticketingTool.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SlaScheduler {
    private final TicketRepository ticketRepository;

    @Scheduled(fixedRate = 60000)
    public void escalatedTicket(){
        List<Ticket> tickets=ticketRepository.findByStatus(TicketStatus.OPEN);

        tickets.stream()
                .filter(t->t.getCreatedAt()
                        .isBefore(LocalDateTime.now().minusMinutes(4)))
                .forEach(t->{
                    t.setStatus(TicketStatus.ESCALATED);
                    ticketRepository.save(t);
                });
    }
}
