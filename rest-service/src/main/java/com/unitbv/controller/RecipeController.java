package com.unitbv.controller;

import com.unitbv.request.CreateRecipeRequest;
import com.unitbv.service.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipesService recipesService;

    @Autowired
    public RecipeController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> addRecipe(@RequestBody CreateRecipeRequest recipe) {
        try {
            return ResponseEntity.ok(recipesService.addRecipe(recipe));
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<CreateRecipeRequest>> getAllRecipes() {
        return ResponseEntity.ok(recipesService.getAllRecipes());
    }
}
