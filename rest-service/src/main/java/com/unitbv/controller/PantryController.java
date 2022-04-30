package com.unitbv.controller;

import com.unitbv.model.Ingredient;
import com.unitbv.service.PantryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pantry")
public class PantryController {

    private final PantryService pantryService;

    @Autowired
    public PantryController(PantryService pantryService){
        this.pantryService = pantryService;
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients(){
        return ResponseEntity.ok(pantryService.getAllIngredients());
    }

    @PostMapping
    public void saveIngredient(@RequestBody Ingredient ingredient) {
        pantryService.saveIngredient(ingredient);
    }

    @PutMapping("/ingredient")
    public void updateIngredient(@RequestBody Ingredient ingredient) {
        pantryService.updateIngredient(ingredient);
    }

    @DeleteMapping("/ingredient/{ingredientName}")
    public void deleteIngredient(@PathVariable String ingredientName) {
        pantryService.deleteIngredient(ingredientName);
    }
}
