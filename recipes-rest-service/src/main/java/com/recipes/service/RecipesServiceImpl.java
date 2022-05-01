package com.recipes.service;

import com.recipes.datasource.MyRecipes;
import com.recipes.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipesServiceImpl implements  RecipesService{
    private final MyRecipes myRecipes;

    @Autowired
    public RecipesServiceImpl(MyRecipes myRecipes) {
        this.myRecipes = myRecipes;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return myRecipes.getAllRecipes();
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        return myRecipes.addRecipe(recipe);
    }
}
