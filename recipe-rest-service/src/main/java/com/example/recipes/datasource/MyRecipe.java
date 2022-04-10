package com.example.recipes.datasource;

import com.example.recipes.model.Ingredient;
import com.example.recipes.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class MyRecipe {
    private List<Recipe> recipes;

    public MyRecipe() {
        recipes = new ArrayList<>();
//        recipes = Stream.of(
//                new Recipe("Classic omelette", new ArrayList<Ingredient>(Arrays.asList(
//                        new Ingredient("Milk", 500, "ml"),
//                        new Ingredient("Eggs", 5, "pieces"),
//                        new Ingredient("Sugar", 200, "g")))),
//                new Recipe("cake2", new ArrayList<Ingredient>(Arrays.asList(
//                        new Ingredient("Milk2", 500, "ml"),
//                        new Ingredient("Eggs2", 5, "pieces"),
//                        new Ingredient("Sugar2", 200, "g"))))
//        ).collect(Collectors.toList());
    }

    public List<Recipe> getAllRecipes() {
        return recipes;
    }

    public Optional<Recipe> findRecipeByName(String name) {
        return recipes.stream().filter(i -> i.getName().equals(name)).findFirst();
    }

    public Recipe saveRecipe(Recipe recipe) {
        findRecipeByName(recipe.getName()).ifPresent(i -> {
            throw new RuntimeException("Recipe with name " + i.getName() + " already exists!");
        });

        if (recipe.getName() == null || recipe.getName().isEmpty()) {
            throw new RuntimeException("Recipe name can not be null!");
        }

        for (Ingredient ingredient : recipe.getIngredients()) {
            if (ingredient.getName() == null || ingredient.getName().isEmpty()) {
                throw new RuntimeException("Ingredient name can not be null!");
            }
        }

        this.recipes.add(recipe);

        return recipe;
    }
}
