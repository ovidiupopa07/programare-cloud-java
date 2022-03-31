package com.pcj.tema4.request;

import com.pcj.tema4.model.Ingredient;
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
