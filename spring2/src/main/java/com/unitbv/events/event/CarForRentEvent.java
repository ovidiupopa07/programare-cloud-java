package com.unitbv.events.event;

import org.springframework.context.ApplicationEvent;
import com.unitbv.events.model.Car;

public class CarForRentEvent extends ApplicationEvent {
    private Car car;
    public CarForRentEvent(Object source) {
        super(source);
    }

    public Car getCar() {
        return this.car;
    }
}
