package com.unitbv.service;

import com.unitbv.datasource.MyPantry;
import com.unitbv.request.CreateRecipeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class CookBookServiceImpl implements CookBookService {
	
	private final RestTemplate restTemplate;
	private final MyPantry pantry;
	
	@Autowired
	public CookBookServiceImpl(RestTemplate restTemplate, MyPantry pantry) {
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
	public CreateRecipeRequest saveRecipe(CreateRecipeRequest recipe) {
		ResponseEntity<CreateRecipeRequest> response =
				restTemplate.postForEntity(
						"http://localhost:8081/api/recipe",
						recipe,
						CreateRecipeRequest.class);
		if (response.getStatusCode().is2xxSuccessful())
			pantry.saveAllIngredients(recipe.getIngredients());
		return response.getBody();
	}
}
