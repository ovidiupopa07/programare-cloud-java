package com.unitbv.service;

import java.util.List;

import com.unitbv.request.CreateRecipeRequest;

public interface RecipeService {
    CreateRecipeRequest saveRecipe(CreateRecipeRequest recipe);
    List<CreateRecipeRequest> getAllRecipes();
}
