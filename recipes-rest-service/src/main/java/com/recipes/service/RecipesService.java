package com.recipes.service;

import com.recipes.model.Recipe;

import java.util.List;

public interface RecipesService {
    List<Recipe> getAllRecipes();

    Recipe addRecipe(Recipe recipe);
}
