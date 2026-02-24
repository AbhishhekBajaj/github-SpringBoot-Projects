package com.Abhishek.ticketingTool.dto;

import com.Abhishek.ticketingTool.entity.Priority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import com.Abhishek.ticketingTool.entity.Priority;

@Getter
@Setter
public class CreateTicketRequest {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Priority priority;
}
