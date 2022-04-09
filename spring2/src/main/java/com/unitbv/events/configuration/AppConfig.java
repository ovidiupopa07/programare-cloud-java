package com.unitbv.events.configuration;

import org.springframework.context.annotation.Configuration;
import com.unitbv.events.service.CarService;
import com.unitbv.events.service.PersonService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

@Configuration
public class AppConfig {
    @Bean
    public PersonService personService(ApplicationEventPublisher eventPublisher) {
        return new PersonService(eventPublisher);
    }

    @Bean
    public CarService carService() {
        return new CarService();
    }
}
