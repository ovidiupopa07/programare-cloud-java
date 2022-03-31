package com.unitbv.controller;

import com.unitbv.model.Ingredient;
import com.unitbv.request.CreateRecipeRequest;
import com.unitbv.service.PantryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/api/recipe")
public class RecipeController {
     public RestTemplate restTemplate;
     public PantryService pantryService;

    @Autowired
    public RecipeController(RestTemplate restTemplate, PantryService pantryService){
        this.restTemplate = restTemplate;
        this.pantryService = pantryService;
    }

    @GetMapping
    @RequestMapping("/all")
    public ResponseEntity<?> getAllRecipes(){
        try {
            ResponseEntity<CreateRecipeRequest[]> response =
                    restTemplate.getForEntity("http://localhost:8081/recipe", CreateRecipeRequest[].class);

            CreateRecipeRequest[] recipes = response.getBody();
            return ResponseEntity.ok(recipes);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    @RequestMapping("/new")
    public ResponseEntity<?> addRecipes(@RequestBody CreateRecipeRequest recipe){

        try {
            CreateRecipeRequest response = restTemplate.postForObject(
                    "http://localhost:8081/recipe",
                    recipe,
                    CreateRecipeRequest.class);

            for(Ingredient ingredient : response.getIngredients()){
                pantryService.saveIngredient(ingredient);
            }

            return getAllRecipes();
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
