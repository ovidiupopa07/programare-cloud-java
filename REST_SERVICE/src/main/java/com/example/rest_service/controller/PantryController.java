package com.example.rest_service.controller;

import com.example.rest_service.model.Ingredient;
import com.example.rest_service.service.PantryService;
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
    public PantryController(PantryService pantryService) {
        this.pantryService = pantryService;
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return ResponseEntity.ok(pantryService.getAllIngredients());
    }

    @PostMapping
    public ResponseEntity<?> postIngredient(@RequestBody Ingredient ingredient) {
        try {
            return ResponseEntity.ok(pantryService.addIngredient(ingredient));
        } catch (RuntimeException re) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(re.getMessage());
        }
    }

    @PutMapping(value = "/{ingredient}")
    public ResponseEntity<?> update(@RequestBody Ingredient ingredient) {
        try {
            return ResponseEntity.ok(pantryService.update(ingredient));
        } catch (RuntimeException re) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(re.getMessage());
        }
    }

    @DeleteMapping(value = "ingredient/{ingredient}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> delete(@PathVariable("ingredient") String ingredient) {
        try {
            return ResponseEntity.ok(pantryService.delete(ingredient));
        } catch (RuntimeException re) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(re.getMessage());
        }
    }
}
