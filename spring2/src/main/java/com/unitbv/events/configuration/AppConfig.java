package com.unitbv.events.configuration;

import com.unitbv.events.service.CarService;
import com.unitbv.events.service.PersonService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PersonService personService(ApplicationEventPublisher publisher) {
        return new PersonService(publisher);
    }

    @Bean
    public CarService carService() {
        return new CarService();
    }
}
