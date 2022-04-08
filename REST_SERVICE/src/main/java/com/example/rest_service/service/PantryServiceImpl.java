package com.example.rest_service.service;

import com.example.rest_service.datasource.MyPantry;
import com.example.rest_service.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PantryServiceImpl implements PantryService{

    private final MyPantry pantry;

    @Autowired
    public PantryServiceImpl(MyPantry pantry){
        this.pantry = pantry;
    }

    @Override
    public List<Ingredient> getAllIngredients(){
        return pantry.getAllIngredients();
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        return pantry.saveIngredient(ingredient);
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        return  pantry.updateIngredient(ingredient);
    }

    @Override
    public boolean delete(String ingredient) {
        return pantry.deleteIngredient(ingredient);
    }
}
