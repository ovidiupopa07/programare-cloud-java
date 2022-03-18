package com.unitbv.properties.stereotype;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
public class Car {
    @Value("${model}")
    private String model;
}