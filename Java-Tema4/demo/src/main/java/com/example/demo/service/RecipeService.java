package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Ingredient;
import com.example.demo.model.Recipe;

public interface RecipeService {
	List<Recipe> getAllRecipes();
	Recipe createRecipe(String name, List<Ingredient> ingredients);
}
