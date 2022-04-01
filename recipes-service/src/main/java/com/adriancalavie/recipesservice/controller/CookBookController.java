package com.adriancalavie.recipesservice.controller;

import com.adriancalavie.recipesservice.model.Ingredient;
import com.adriancalavie.recipesservice.model.Recipe;
import com.adriancalavie.recipesservice.service.CookBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class CookBookController {
	
	private final CookBookService cookBookService;
	
	@Autowired
	public CookBookController(CookBookService cookBookService) {
		this.cookBookService = cookBookService;
	}
	
	@GetMapping
	public ResponseEntity<List<Recipe>> getAllRecipes() {
		return ResponseEntity.ok(cookBookService.getAllRecipes());
	}
	
	@PostMapping
	public ResponseEntity<?> createRecipe(@RequestBody Recipe recipe) {
		try {
			return ResponseEntity.ok(cookBookService.saveRecipe(recipe));
		} catch (RuntimeException exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
		}
	}
}
