package com.unitbv.model;

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
    
    public Ingredient(String name, double quantity, String unitOfMeasurement) {
    	this.setName(name);
    	this.setQuantity(quantity);
    	this.setUnitOfMeasurement(unitOfMeasurement);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		this.unitOfMeasurement = unitOfMeasurement;
	}
}
