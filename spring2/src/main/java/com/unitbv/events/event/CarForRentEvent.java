package com.unitbv.events.event;

import com.unitbv.events.model.Car;
import org.springframework.context.ApplicationEvent;

public class CarForRentEvent extends ApplicationEvent {
    private Car car;

    public CarForRentEvent(Object source) {
        super(source);
    }

    public Car getCar() {
        return this.car;
    }
}