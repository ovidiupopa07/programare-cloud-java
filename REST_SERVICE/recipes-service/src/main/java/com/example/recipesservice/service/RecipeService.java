package com.example.recipesservice.service;

import com.example.recipesservice.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RecipeService {
    List<Recipe> findAll();

    void delete(Recipe person);

    Recipe addRecipe(Recipe recipe);

    List<Recipe> getAll();
}
