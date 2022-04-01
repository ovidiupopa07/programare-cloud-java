package com.adriancalavie.recipesservice.service;

import com.adriancalavie.recipesservice.model.Recipe;

import java.util.List;

public interface CookBookService {
	List<Recipe> getAllRecipes();
	Recipe saveRecipe(Recipe recipe);
}
