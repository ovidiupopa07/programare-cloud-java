package com.example.recipes.service;

import com.example.recipes.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();

    Recipe saveRecipe(Recipe recipe);
}
