package com.unitbv.service;

import com.unitbv.datasource.MyPantry;
import com.unitbv.model.Ingredient;
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
    public Ingredient saveIngredient(Ingredient ingredient) {
        return pantry.saveIngredient(ingredient);
    }

    @Override
    public Ingredient updateIngredient(Ingredient ingredient) {
        return pantry.updateIngredient(ingredient);
    }

    @Override
    public boolean deleteIngredient(String name) {
        return pantry.deleteIngredient(name);
    }

    @Override
    public List<Ingredient> getAllIngredients(){
        return pantry.getAllIngredients();
    }
}
