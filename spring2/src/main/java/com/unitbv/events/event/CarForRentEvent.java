package com.unitbv.events.event;

import org.springframework.context.ApplicationEvent;

public class CarForRentEvent extends ApplicationEvent {
    public CarForRentEvent(Object source) {
        super(source);
    }

    public Object getCar() {
        return source;
    }
}
