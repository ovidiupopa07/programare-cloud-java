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
public class RecipesController {
    final RecipesService recipesService;

    @Autowired
    public RecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CreateRecipeRequest>> getAllRecipes() {
        return ResponseEntity.ok(recipesService.getAllRecipes());
    }

    @PostMapping("/new")
    public  ResponseEntity<?> saveRecipe(@RequestBody CreateRecipeRequest recipe) {
        try {
            return ResponseEntity.ok(recipesService.saveRecipe(recipe));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}