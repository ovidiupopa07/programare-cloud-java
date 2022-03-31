package com.pcj.tema4.service;

import com.pcj.tema4.model.Recipe;

import java.util.List;

public interface RecipeBookService {
    List<Recipe> getAllRecipes();
    boolean saveRecipe(Recipe recipe);
}
