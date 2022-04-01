package com.example.recipe.service;

import com.example.recipe.model.Ingredient;
import com.example.recipe.model.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();

    Recipe addRecipe(String name, List<Ingredient> ingredients);
}
