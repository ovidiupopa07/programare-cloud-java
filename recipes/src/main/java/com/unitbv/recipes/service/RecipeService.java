package com.unitbv.recipes.service;

import com.unitbv.recipes.model.Recipe;
import java.util.List;

public interface RecipeService {
    List<Recipe> getAllRecipes();

    Recipe saveRecipe(Recipe recipe);
}
