package com.example.rest_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ingredient {
    private String name;
    private double quantity;
    private String unitOfMeasurement;
}
