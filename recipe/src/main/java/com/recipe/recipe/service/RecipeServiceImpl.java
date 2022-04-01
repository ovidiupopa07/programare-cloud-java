package com.recipe.recipe.service;

import com.recipe.recipe.datasource.MyRecipe;
import com.recipe.recipe.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final MyRecipe recipe;

    @Autowired
    public RecipeServiceImpl(MyRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipe.getAllRecipes();
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return this.recipe.saveRecipe(recipe);
    }
}
