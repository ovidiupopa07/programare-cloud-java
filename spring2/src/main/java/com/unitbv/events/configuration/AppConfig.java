package com.unitbv.events.configuration;

import com.unitbv.events.event.CarForRentEvent;
import com.unitbv.events.model.Car;
import com.unitbv.events.service.PersonService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.unitbv.events")
public class AppConfig {
}
