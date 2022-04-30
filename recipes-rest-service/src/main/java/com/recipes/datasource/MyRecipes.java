package com.recipes.datasource;

import com.recipes.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MyRecipes {
    private List<Recipe> recipes;

    public MyRecipes() { recipes = new ArrayList<>(); }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    public Optional<Recipe> findRecipeByName(String name) {
        return recipes.stream().filter(recipe -> recipe.getName().equals(name)).findFirst();
    }

    public Recipe addRecipe(Recipe recipe) {
        this.recipes.add(recipe);

        return recipe;
    }
}
