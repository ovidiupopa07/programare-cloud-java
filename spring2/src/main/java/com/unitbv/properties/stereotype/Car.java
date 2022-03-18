package com.unitbv.properties.stereotype;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Component
@PropertySource("classpath:application.properties")
public class Car {
    @Value("${car.model}")
    private String model;

}