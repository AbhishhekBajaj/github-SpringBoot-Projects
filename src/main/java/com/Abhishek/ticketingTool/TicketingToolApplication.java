package com.Abhishek.ticketingTool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class TicketingToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketingToolApplication.class, args);
	}

}
