package model;

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
    	this.name = name;
    	this.quantity = quantity;
    	this.unitOfMeasurement = unitOfMeasurement;
    }

	public String getName() {
		return name;
	}

	public double getQuantity() {
		return quantity;
	}

	public String getUnitOfMeasurement() {
		return unitOfMeasurement;
	}
}
