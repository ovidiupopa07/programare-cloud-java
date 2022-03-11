package com.unitbv.request;

import com.unitbv.model.Ingredient;
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
    
    public CreateRecipeRequest(String name, List<Ingredient> ingredients) {
    	this.setName(name);
    	this.setIngredients(ingredients);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
