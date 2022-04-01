package com.example.recipe.datasource;

import com.example.recipe.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MyRecipe {
    private List<Recipe> recipes;

    public MyRecipe() {
        recipes = new ArrayList<>();
    }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    public Recipe addRecipe(Recipe recipe) {
        recipes.add(recipe);
        return recipe;
    }

    public Optional<Recipe> searchByName(String name) {
        return recipes.stream().filter(x -> x.getName().equals(name)).findFirst();
    }
}
