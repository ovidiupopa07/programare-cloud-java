package com.unitbv.events.configuration;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unitbv.events.service.CarService;
import com.unitbv.events.service.PersonService;

@Configuration
public class AppConfig {
	ApplicationEventPublisher eventPublisher;
	
	@Bean
	PersonService personService() {
		return new PersonService(eventPublisher);
	}
	
	@Bean
	CarService carService() {
		return new CarService();
	}
}
