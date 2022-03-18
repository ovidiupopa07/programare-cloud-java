package com.unitbv.properties.config;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }
}
