package com.example.recipe.controller;

import com.example.recipe.model.Ingredient;
import com.example.recipe.model.Recipe;
import com.example.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @PostMapping
    public ResponseEntity<?> createRecipe(String name, List<Ingredient> ingredients) {
        if (name.equals(null)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing recipe name.");
        }

        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(null)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing ingredient name.");
            }
        }

        return ResponseEntity.ok(recipeService.addRecipe(name, ingredients));
    }
}