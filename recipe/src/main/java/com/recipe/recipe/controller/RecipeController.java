package com.recipe.recipe.controller;

import com.recipe.recipe.model.Recipe;
import com.recipe.recipe.service.RecipeService;
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

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes(){
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @PostMapping
    public ResponseEntity<?> saveRecipe(@RequestBody Recipe recipe){
        try {
            return ResponseEntity.ok(recipeService.saveRecipe(recipe));
        }catch (RuntimeException e){
                if(e.getMessage().equals("Recipe name can't be null or empty!")){
                    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
                }else if(e.getMessage().equals("Ingredient name can't be null or empty!")){
                    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
                }else{
                    return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(e.getMessage());
                }
        }

    }

}
