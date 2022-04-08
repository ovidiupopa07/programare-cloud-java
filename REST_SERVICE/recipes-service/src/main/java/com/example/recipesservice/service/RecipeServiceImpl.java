package com.example.recipesservice.service;

import com.example.recipesservice.model.Recipe;
import com.example.recipesservice.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepo;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @Override
    public List<Recipe> findAll() {
        return recipeRepo.getAll();
    }

    @Override
    public void delete(Recipe recipe) {

    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        return recipeRepo.set(recipe);
    }

    @Override
    public List<Recipe> getAll() {
        return recipeRepo.getAll();
    }
}
