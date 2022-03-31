package com.recipe.recipe.service;

import com.recipe.recipe.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();
    Recipe saveRecipe(Recipe recipe);
}
