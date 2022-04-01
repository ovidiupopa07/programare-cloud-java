package service;

import java.util.List;

import model.Ingredient;
import model.Recipe;

public interface RecipeService {
	List<Recipe> getAllRecipes();
	Recipe createRecipe(String name, List<Ingredient> ingredients);
}
