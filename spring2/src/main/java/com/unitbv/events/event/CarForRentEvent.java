package com.unitbv.events.event;

import com.unitbv.events.model.Car;
import org.springframework.context.ApplicationEvent;

public class CarForRentEvent extends ApplicationEvent {
    private Car car;
    public CarForRentEvent(Object source, Car car) {
        super(source);
        this.car = car;
    }

    public Car getCar() {
        return this.car;
    }
}
