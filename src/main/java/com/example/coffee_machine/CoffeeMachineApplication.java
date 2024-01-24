package com.example.coffee_machine;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@SpringBootApplication
@Slf4j
public class CoffeeMachineApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeMachineApplication.class, args);
        log.error("Start Program Coffee Machine");
    }

}
