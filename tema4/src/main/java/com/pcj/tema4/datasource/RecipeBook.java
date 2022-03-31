package com.pcj.tema4.datasource;


import com.pcj.tema4.model.Recipe;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeBook {

    final private List<Recipe> recipes;

    public RecipeBook() {
        recipes = new ArrayList<>();
    }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    public void saveRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
}
