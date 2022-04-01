package com.unitbv.service;

import com.unitbv.model.Ingredient;

import java.util.List;

public interface PantryService {
    Ingredient saveIngredient(Ingredient ingredient);
    Ingredient updateIngredient(Ingredient ingredient);
    boolean deleteIngredient(String name);
    List<Ingredient> getAllIngredients();
}
