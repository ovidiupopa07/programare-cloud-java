package com.unitbv.properties.config;

import lombok.Getter;

@Getter
public class Car {
    private String model;

    public Car(String model) {
        this.model = model;
    }
}
