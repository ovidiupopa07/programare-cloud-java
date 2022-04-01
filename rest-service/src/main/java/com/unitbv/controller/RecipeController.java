package com.unitbv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.unitbv.model.Ingredient;
import com.unitbv.request.CreateRecipeRequest;
import com.unitbv.service.PantryService;
import com.unitbv.service.RecipeService;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
     private final RecipeService recipeService;

     @Autowired
     public RecipeController(RecipeService recipeService){
         this.recipeService = recipeService;
     }

     @GetMapping("/all")
     public ResponseEntity<List<CreateRecipeRequest>> getAllRecipes() {
         return ResponseEntity.ok(recipeService.getAllRecipes());
     }

     @PostMapping("/new")
     public  ResponseEntity<?> saveRecipe(@RequestBody CreateRecipeRequest recipe) {
         try {
             return ResponseEntity.ok(recipeService.saveRecipe(recipe));
         } catch (RuntimeException e) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
         }
     }
}