package com.unitbv.request;

import com.unitbv.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateRecipeRequest {
    private String name;
    private List<Ingredient> ingredients;
}
