package com.unitbv.service;

import com.unitbv.model.Ingredient;

import java.util.List;

public interface PantryService {
    List<Ingredient> getAllIngredients();
    Ingredient addIngredient(Ingredient ingredient);
    Ingredient updateIngredient(Ingredient ingredient);
    boolean deleteIngredient(String name);
}
