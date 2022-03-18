package com.unitbv.events;

import com.unitbv.events.configuration.AppConfig;
import com.unitbv.events.service.CarService;
import com.unitbv.events.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpringEventsTest {

    // Publish an event on PersonService that will be consumed in CarService
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        final PersonService personService = context.getBean(PersonService.class);
        personService.rentCar("Audi");

        final CarService carService = context.getBean(CarService.class);

        assertEquals(carService.getAvailableCars().size(), 1);
    }
}
