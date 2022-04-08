package com.example.rest_service.request;

import com.example.rest_service.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRecipeRequest {
    private String name;
    private List<Ingredient> ingredients;
}
