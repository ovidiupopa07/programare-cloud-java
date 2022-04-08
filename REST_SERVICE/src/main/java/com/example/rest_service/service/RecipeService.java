package com.example.rest_service.service;

import com.example.rest_service.datasource.MyPantry;
import com.example.rest_service.request.CreateRecipeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {
    List<CreateRecipeRequest> getAllRecipes();
    CreateRecipeRequest addRecipe(CreateRecipeRequest recipeRequest);
}
