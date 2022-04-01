package com.recipe.recipe.datasource;

import com.recipe.recipe.model.Ingredient;
import com.recipe.recipe.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class MyRecipe {


    private List<Recipe> recipes;


    public List<Recipe> getAllRecipes(){
        return recipes;
    }

    public Optional<Recipe> findRecipeByName(String name){
        return recipes.stream().filter(i -> i.getName().equals(name)).findFirst();
    }

    public Recipe saveRecipe(Recipe recipe){
        findRecipeByName(recipe.getName()).ifPresent(i -> {
            throw new RuntimeException("Recipe with name " + i.getName() + " already exists!");
        });

        if(recipe.getName().isEmpty() || recipe.getName() == null){
            throw new RuntimeException("Recipe name can't be null or empty!");
        }

        for(Ingredient ing: recipe.getIngredients()){
            if(ing.getName().isEmpty() || ing.getName() == null){
                throw new RuntimeException("Ingredient name can't be null or empty!");
            }
        }
        this.recipes.add(recipe);

        return recipe;
    }


}
