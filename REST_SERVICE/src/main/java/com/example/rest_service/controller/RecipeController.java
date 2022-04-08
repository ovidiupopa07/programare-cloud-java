package com.example.rest_service.controller;

import com.example.rest_service.request.CreateRecipeRequest;
import com.example.rest_service.service.RecipeService;
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

    @GetMapping("/all")
    public ResponseEntity<List<CreateRecipeRequest>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @PostMapping("/new")
    public ResponseEntity<?> createNewRecipe(@RequestBody CreateRecipeRequest recipe) {
        try {
            return ResponseEntity.ok(recipeService.addRecipe(recipe));
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

}
