package com.unitbv.recipes.controller;

import com.unitbv.recipes.model.Recipe;
import com.unitbv.recipes.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping()
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @PostMapping
    public ResponseEntity<?> saveRecipe(@RequestBody Recipe recipe) {
        try {
            return ResponseEntity.ok(recipeService.saveRecipe(recipe));
        } catch (RuntimeException exception) {
            switch (exception.getMessage()) {
                case "Recipe name can not be null!", "Ingredient name can not be null!" -> {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
                }
            }
        }
    }
}
