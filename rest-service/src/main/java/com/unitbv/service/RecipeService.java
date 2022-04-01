package com.unitbv.service;

import com.unitbv.request.CreateRecipeRequest;

import java.util.List;

public interface RecipeService {
    CreateRecipeRequest saveRecipe(CreateRecipeRequest recipe);

    List<CreateRecipeRequest> getAllRecipes();
}
