package com.adriancalavie.recipesservice.service;

import com.adriancalavie.recipesservice.datasource.MyCookBook;
import com.adriancalavie.recipesservice.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CookBookServiceImpl implements CookBookService {
	
	private final MyCookBook cookBook;
	
	@Autowired
	public CookBookServiceImpl(MyCookBook cookBook) {
		this.cookBook = cookBook;
	}
	
	
	@Override
	public List<Recipe> getAllRecipes() {
		return cookBook.getAllRecipes();
	}
	
	@Override
	public Recipe saveRecipe(Recipe recipe) {
		return cookBook.saveRecipe(recipe);
	}
}
