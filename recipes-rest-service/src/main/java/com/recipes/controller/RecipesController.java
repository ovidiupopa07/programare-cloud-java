package com.recipes.controller;

import com.recipes.model.Ingredient;
import com.recipes.model.Recipe;
import com.recipes.service.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/recipe")
public class RecipesController {
    private final RecipesService recipesService;

    @Autowired
    public RecipesController(RecipesService recipesService){
        this.recipesService = recipesService;
    }

    @GetMapping()
    public ResponseEntity<List<Recipe>> getAllRecipes(){
        return ResponseEntity.ok(recipesService.getAllRecipes());
    }

    @PostMapping
    public ResponseEntity<?> addRecipe(@RequestBody Recipe recipe) {
        if(recipe.getName().trim().isEmpty() || recipe.getName() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Recipe name cannot be empty or null!");
        }

        for(Ingredient ingredient : recipe.getIngredients()) {
            if(ingredient.getName().trim().isEmpty() || ingredient.getName() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ingredient name cannot be empty or null!");
            }
        }

        return ResponseEntity.ok(recipesService.addRecipe(recipe));
    }
}
