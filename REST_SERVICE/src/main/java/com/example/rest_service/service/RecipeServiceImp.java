package com.example.rest_service.service;

import com.example.rest_service.datasource.MyPantry;
import com.example.rest_service.request.CreateRecipeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class RecipeServiceImp implements RecipeService {
    private final RestTemplate restTemplate;
    private final MyPantry pantry;

    public RecipeServiceImp(RestTemplate restTemplate, MyPantry pantry) {
        this.restTemplate = restTemplate;
        this.pantry = pantry;
    }

    @Override
    public List<CreateRecipeRequest> getAllRecipes() {
        ResponseEntity<CreateRecipeRequest[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8081/api/recipe",
                        CreateRecipeRequest[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }

    @Override
    public CreateRecipeRequest addRecipe(CreateRecipeRequest recipeRequest) {
        ResponseEntity<CreateRecipeRequest> response =
                restTemplate.postForEntity(
                        "http://localhost:8081/api/recipe",
                        recipeRequest,
                        CreateRecipeRequest.class);
        if (response.getStatusCode().is2xxSuccessful())
            pantry.saveAllIngredients(recipeRequest.getIngredients());
        return response.getBody();
    }
}
