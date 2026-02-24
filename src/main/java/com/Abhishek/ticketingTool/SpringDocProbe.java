package com.Abhishek.ticketingTool;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class SpringDocProbe {

    @PostConstruct
    public void test() {
        System.out.println(">>> SPRINGDOC PROBE LOADED <<<");
    }
}
