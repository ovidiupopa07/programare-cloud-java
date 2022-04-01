package com.unitbv.controller;

import com.unitbv.model.Ingredient;
import com.unitbv.service.PantryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> saveIngredient(@RequestBody Ingredient ingredient) {
        try {
            return ResponseEntity.ok(pantryService.saveIngredient(ingredient));
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
        }
    }

    @PutMapping("/ingredient")
    public ResponseEntity<?> updateIngredient(@RequestBody Ingredient ingredient) {
        try {
            return ResponseEntity.ok(pantryService.updateIngredient(ingredient));
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/ingredient/{ingredientName}")
    public ResponseEntity<?> deleteIngredient(@PathVariable String ingredientName) {
        try {
            return ResponseEntity.ok(pantryService.deleteIngredient(ingredientName));
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}
