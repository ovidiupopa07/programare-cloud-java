package com.unitbv.service;

import com.unitbv.model.Ingredient;

import java.util.List;

public interface PantryService {
    List<Ingredient> getAllIngredients();

    Ingredient saveIngredient(Ingredient ingredient);

    List<Ingredient> saveAllIngredients(List<Ingredient> ingredients);

    Ingredient updateIngredient(Ingredient ingredient);

    boolean deleteIngredient(String name);
}
