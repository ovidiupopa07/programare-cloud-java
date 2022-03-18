package com.unitbv.events.service;

import com.unitbv.events.event.CarForRentEvent;
import com.unitbv.events.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public PersonService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void rentCar(String model) {
        final Car car = new Car(model);
        //create a new event and publish car on event
        CarForRentEvent event = new CarForRentEvent(this, car);
        eventPublisher.publishEvent(event);
    }
}
