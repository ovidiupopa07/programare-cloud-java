package com.example.recipesservice.repository;

import com.example.recipesservice.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecipeRepository extends RuntimeException{
    private List<Recipe> recipes;

    @Autowired
    public RecipeRepository(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public List<Recipe> getAll() {
        return recipes;
    }

    public Recipe set(Recipe recipe) {
        recipes.add(recipe);
        return recipe;
    }
}
