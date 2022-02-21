package com.unitbv.datasource;

import com.unitbv.model.Ingredient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class MyPantry {

    private List<Ingredient> ingredients;

    public MyPantry(){
        ingredients = Stream.of(
                new Ingredient("Milk", 500, "ml"),
                new Ingredient("Meat", 1500, "g"),
                new Ingredient("Tomatoes", 12, "pieces"),
                new Ingredient("Fries", 650, "g"),
                new Ingredient("Olive oil", 200, "ml")
        ).collect(Collectors.toList());
    }

    public List<Ingredient> getAllIngredients(){
        return ingredients;
    }

    public Optional<Ingredient> findIngredientByName(String name){
        return ingredients.stream().filter(i -> i.getName().equals(name)).findFirst();
    }

    public Ingredient saveIngredient(Ingredient ingredient){
        findIngredientByName(ingredient.getName()).ifPresent(i -> {
            throw new RuntimeException("Ingredient with name " + i.getName() + " already exists!");
        });
        this.ingredients.add(ingredient);

        return ingredient;
    }

    public List<Ingredient> saveAllIngredients(List<Ingredient> ingredientsToAdd){
        ingredientsToAdd.forEach(ingredient -> {
            findIngredientByName(ingredient.getName()).ifPresent(i -> {
                throw new RuntimeException("Ingredient with name " + i.getName() + " already exists!");
            });
        });
        this.ingredients.addAll(ingredientsToAdd);

        return ingredientsToAdd;
    }

    public Ingredient updateIngredient(Ingredient ingredient){
        Ingredient existingIngredient = findIngredientByName(ingredient.getName()).orElseThrow(
                () -> new RuntimeException("Ingredient with name " + ingredient.getName() + " not found!"));
        int index = ingredients.indexOf(existingIngredient);
        ingredients.add(index, ingredient);

        return ingredient;
    }

    public boolean deleteIngredient(String name){
        Ingredient ingredient = findIngredientByName(name).orElseThrow(
                () -> new RuntimeException("Ingredient with name " + name + " not found!"));

        return ingredients.remove(ingredient);
    }
}
