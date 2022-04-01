package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recipe {
	private String name;
    private List<Ingredient> ingredients;
    
    public Recipe(String name, List<Ingredient> ingredients) {
    	this.name = name;
    	this.ingredients = ingredients;
    }

	public String getName() {
		return name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
}
