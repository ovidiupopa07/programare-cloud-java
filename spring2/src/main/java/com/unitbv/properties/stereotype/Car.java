package com.unitbv.properties.stereotype;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@PropertySource("application.properties")
@Component
public class Car {
    @Value("${car.model}")
    private String model;

}