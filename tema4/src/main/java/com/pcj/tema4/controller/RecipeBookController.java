package com.pcj.tema4.controller;

import com.pcj.tema4.model.Recipe;
import com.pcj.tema4.service.RecipeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeBookController {

    private final RecipeBookService recipeBookService;

    @Autowired
    public RecipeBookController(RecipeBookService recipeBookService) {
        this.recipeBookService = recipeBookService;
    }

    @GetMapping("/api/recipe/all")
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeBookService.getAllRecipes());
    }

    @PostMapping("/api/recipe/new")
    public ResponseEntity<List<Recipe>> newRecipe(@RequestBody Recipe recipe) {
        if (!recipeBookService.saveRecipe(recipe)) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            List<Recipe> recipeList = new ArrayList<>();
            recipeList.add(recipe);
            return ResponseEntity.ok(recipeList);
        }

    }
}
