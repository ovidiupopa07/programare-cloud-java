package com.unitbv.properties.programatically;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Getter
@RequiredArgsConstructor
@Component
public class Car {
    private final String model;
}
