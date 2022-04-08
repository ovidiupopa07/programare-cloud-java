package com.example.rest_service.service;

import com.example.rest_service.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PantryService {
    List<Ingredient> getAllIngredients();

    Ingredient addIngredient(Ingredient ingredient);

    Ingredient update(Ingredient ingredient);

    boolean delete(String ingredient);
}
