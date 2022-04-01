package com.unitbv.service;

import com.unitbv.request.CreateRecipeRequest;

import java.util.List;

public interface RecipeService {
    List<CreateRecipeRequest> getAllRecipes();

    CreateRecipeRequest saveRecipe(CreateRecipeRequest recipe);
}
