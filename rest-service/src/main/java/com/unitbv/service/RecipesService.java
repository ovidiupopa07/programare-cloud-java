package com.unitbv.service;


import com.unitbv.request.CreateRecipeRequest;

import java.util.List;

public interface RecipesService {
    CreateRecipeRequest saveRecipe(CreateRecipeRequest recipe);
    List<CreateRecipeRequest> getAllRecipes();
}

