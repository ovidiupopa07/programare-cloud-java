package com.unitbv.properties.stereotype;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
@PropertySource("classpath:application.properties")
public class Car {
    @Value("${car.model}")
    private String model;

}