package com.example.recipe.service;

import com.example.recipe.datasource.MyRecipe;
import com.example.recipe.model.Ingredient;
import com.example.recipe.model.Recipe;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {
    private final MyRecipe myRecipe;

    @Override
    public List<Recipe> getAllRecipes() {
        return myRecipe.getAllRecipes();
    }

    @Override
    public Recipe addRecipe(String name, List<Ingredient> ingredients) {
        return myRecipe.addRecipe(new Recipe(name, ingredients));
    }
}
