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
    public ResponseEntity<?> createIngredient(@RequestBody Ingredient ingredient){
        try {
            return ResponseEntity.ok(pantryService.saveIngredient(ingredient));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Ingredient with name Milk already exists!");
        }
    }

    @PutMapping(value = "/ingredient")
    public ResponseEntity<?> updateIngredient(@RequestBody Ingredient ingredient){
        try {
            return ResponseEntity.ok(pantryService.updateIngredient(ingredient));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingredient with name Flour not found!");
        }
    }

    @DeleteMapping(value = "/ingredient/{name}")
    public ResponseEntity<?> deleteIngredient(@PathVariable String name){
        try {
            return ResponseEntity.ok(pantryService.deleteIngredient(name));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ingredient with name Flour not found!");
        }
    }
}
