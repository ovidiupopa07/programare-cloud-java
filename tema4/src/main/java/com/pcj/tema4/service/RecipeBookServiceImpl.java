package com.pcj.tema4.service;

import com.pcj.tema4.datasource.RecipeBook;
import com.pcj.tema4.model.Ingredient;
import com.pcj.tema4.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeBookServiceImpl  implements RecipeBookService{
    private final RecipeBook recipeBook;

    @Autowired
    public RecipeBookServiceImpl(RecipeBook recipeBook) {
        this.recipeBook = recipeBook;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeBook.getAllRecipes();
    }

    @Override
    public boolean saveRecipe(Recipe recipe) {
        if(recipe.getName() == null) {
            return false;
        }
        for(Ingredient ingredient : recipe.getIngredients()) {
            if(ingredient.getName() == null) {
                return false;
            }
        }
        recipeBook.saveRecipe(recipe);
        return true;
    }
}
