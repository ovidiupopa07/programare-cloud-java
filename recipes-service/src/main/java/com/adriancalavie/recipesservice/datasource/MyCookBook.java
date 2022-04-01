package com.adriancalavie.recipesservice.datasource;

import com.adriancalavie.recipesservice.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MyCookBook {
	private final List<Recipe> recipes;
	
	public MyCookBook() {
		this.recipes = new ArrayList<>();
	}
	
	public List<Recipe> getAllRecipes() {
		return recipes;
	}
	
	public Optional<Recipe> findRecipeByName(String name) {
		return recipes.stream().filter(recipe -> recipe.getName().equals(name)).findFirst();
	}
	
	public Recipe saveRecipe(Recipe recipe) {
		findRecipeByName(recipe.getName()).ifPresent(r -> {
			throw new RuntimeException("Recipe with name " + r.getName() + " already exists!");
		});
		
		if(recipe.getName()== null || recipe.getIngredients() == null){
			throw new RuntimeException("Recipe components cannot be null");
		}
		
		this.recipes.add(recipe);
		
		return recipe;
	}
}
