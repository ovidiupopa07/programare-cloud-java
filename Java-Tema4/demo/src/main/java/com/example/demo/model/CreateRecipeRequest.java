package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRecipeRequest {
	private String name;
    private List<Ingredient> ingredients;
    

    public CreateRecipeRequest() {
		super();
	}
    
    public CreateRecipeRequest(String name, List<Ingredient> ingredients) {
    	this.name = name;
    	this.ingredients = ingredients;
    }

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
}
