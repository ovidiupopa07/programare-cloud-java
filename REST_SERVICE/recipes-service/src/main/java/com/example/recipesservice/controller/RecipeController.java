package com.example.recipesservice.controller;

import com.example.recipesservice.model.Recipe;
import com.example.recipesservice.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @PostMapping(value = "/new")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }


    @GetMapping(value = "/all")
    public List<Recipe> getIngredient() {
        return recipeService.getAll();
    }
}
