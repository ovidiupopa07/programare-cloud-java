package com.example.demo.datasource;

import org.springframework.stereotype.Component;

import com.example.demo.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeSource {

    private List<Recipe> recipes;

    public RecipeSource(){
        recipes = new ArrayList<>();
    }

	public List<Recipe> getRecipes() {
		return recipes;
	}
	
	public Recipe AddRecipe(Recipe recipe) {		
		recipes.add(recipe);
		return recipe;
	}
	
	public Optional<Recipe> searchByName(String name) {
        return recipes.stream().filter(x -> x.getName().equals(name)).findFirst();
    }
}
