package com.unitbv.properties.stereotype;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class Car {
    @Value("${car.model}")
    private String model;

}