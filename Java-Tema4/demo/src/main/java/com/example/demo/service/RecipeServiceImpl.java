package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.datasource.RecipeSource;
import com.example.demo.model.Ingredient;
import com.example.demo.model.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService {
	private final RecipeSource recipeSource;

    @Autowired
    public RecipeServiceImpl(RecipeSource recipeSource){
        this.recipeSource = recipeSource;
    }

    @Override
    public List<Recipe> getAllRecipes(){
        return recipeSource.getRecipes();
    }
    
    @Override
    public Recipe createRecipe(String name, List<Ingredient> ingredients) {
        return recipeSource.AddRecipe(new Recipe(name, ingredients));
    }
}