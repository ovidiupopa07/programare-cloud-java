package com.unitbv.service;

import com.unitbv.request.CreateRecipeRequest;

import java.util.List;

public interface CookBookService {
	
	List<CreateRecipeRequest> getAllRecipes();
	
	CreateRecipeRequest saveRecipe(CreateRecipeRequest recipeRequest);
}
