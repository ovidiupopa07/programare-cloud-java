package com.example.recipesservice.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recipe {
    String name;
    List<Ingredient> ingredients;
}
