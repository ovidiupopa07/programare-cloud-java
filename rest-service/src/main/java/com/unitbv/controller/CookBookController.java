package com.unitbv.controller;

import com.unitbv.request.CreateRecipeRequest;
import com.unitbv.service.CookBookService;
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
	
	@GetMapping("/all")
	public ResponseEntity<List<CreateRecipeRequest>> getAllRecipes() {
		return ResponseEntity.ok(cookBookService.getAllRecipes());
	}
	
	@PostMapping("/new")
	public ResponseEntity<?> createNewRecipe(@RequestBody CreateRecipeRequest recipe) {
		try {
			return ResponseEntity.ok(cookBookService.saveRecipe(recipe));
		} catch (RuntimeException exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
		}
	}
}
