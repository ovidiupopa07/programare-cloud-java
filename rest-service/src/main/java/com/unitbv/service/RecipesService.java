package com.unitbv.service;

import com.unitbv.request.CreateRecipeRequest;

import java.util.List;

public interface RecipesService {
    List<CreateRecipeRequest> getAllRecipes();

    CreateRecipeRequest addRecipe(CreateRecipeRequest recipe);
}
