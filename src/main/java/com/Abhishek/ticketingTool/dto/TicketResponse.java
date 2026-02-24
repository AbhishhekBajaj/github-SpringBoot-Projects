package com.Abhishek.ticketingTool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TicketResponse {
    private Long id;
    private String title;
    private String status;
    private String priority;
}
