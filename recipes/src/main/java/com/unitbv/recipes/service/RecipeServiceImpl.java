package com.unitbv.recipes.service;

import com.unitbv.recipes.datasource.MyRecipe;
import com.unitbv.recipes.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{

    private final MyRecipe myRecipe;

    @Autowired
    public RecipeServiceImpl(MyRecipe myRecipe) {
        this.myRecipe = myRecipe;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return myRecipe.getAllRecipes();
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return myRecipe.saveRecipe(recipe);
    }
}
