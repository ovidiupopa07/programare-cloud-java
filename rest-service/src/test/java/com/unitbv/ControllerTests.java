package com.unitbv;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unitbv.model.Ingredient;
import com.unitbv.request.CreateRecipeRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // GET ALL
    @Test
    public void shouldReturnListOfIngredients() throws Exception {
        this.mockMvc.perform(get("/api/pantry"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].name").value(containsInAnyOrder("Milk", "Meat", "Tomatoes", "Fries", "Olive oil")));
    }

    // CREATE
    @Test
    public void shouldSaveAndReturnIngredientIfSuccessful() throws Exception {
        Ingredient request = new Ingredient("Eggs", 10, "pieces");
        this.mockMvc.perform(post("/api/pantry").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\": \"Eggs\", \"quantity\":  10, \"unitOfMeasurement\": \"pieces\"}"));

        this.mockMvc.perform(get("/api/pantry"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].name").value(containsInAnyOrder("Milk", "Meat", "Tomatoes", "Fries", "Olive oil", "Eggs")));
    }

    // UPDATE
    @Test
    public void shouldUpdateAndReturnIngredientIfSuccessful() throws Exception {
        Ingredient request = new Ingredient("Tomatoes", 20, "pieces");
        this.mockMvc.perform(put("/api/pantry/ingredient").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"name\": \"Tomatoes\", \"quantity\":  20, \"unitOfMeasurement\": \"pieces\"}"));

        this.mockMvc.perform(get("/api/pantry"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[?(@.name == \"Tomatoes\" && @.quantity == 20)]").exists());
    }

    // DELETE
    @Test
    public void shouldDeleteAndReturnTrueIfSuccessful() throws Exception {
        this.mockMvc.perform(delete("/api/pantry/ingredient/Milk"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

        this.mockMvc.perform(get("/api/pantry"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].name").value(containsInAnyOrder("Meat", "Tomatoes", "Fries", "Olive oil")));
    }

    // 409 CONFLICT
    @Test
    public void shouldReturn409ConflictWhenIngredientNameAlreadyExists() throws Exception {
        Ingredient request = new Ingredient("Milk", 100, "ml");
        this.mockMvc.perform(post("/api/pantry").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isConflict())
                .andExpect(content().string("Ingredient with name Milk already exists!"));
    }

    // 404 NOT FOUND - applies for both PUT and DELETE endpoints
    @Test
    public void shouldReturn404NotFoundWhenIngredientIsNotFound() throws Exception {
        Ingredient request = new Ingredient("Flour", 500, "g");
        this.mockMvc.perform(put("/api/pantry/ingredient").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Ingredient with name Flour not found!"));

        this.mockMvc.perform(delete("/api/pantry/ingredient/Flour"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Ingredient with name Flour not found!"));
    }

    /**
     * TO DO - Recipes Service
     * Create another Spring Boot application (you can use https://start.spring.io/). Name it whatever you want.
     * Make sure that the project type is Maven, the language is Java and the packaging is jar.
     * Add the Spring Web dependency. After generated, set its port to 8081.
     * <p>
     * What should it do?
     * 1. It should be able to return the list of existing recipes
     * 2. It should be able to create a new recipe based on a given name and a list of ingredients
     * <p>
     * What you need to do?
     * 1. Create 2 model classes, for recipe and ingredient (a recipe has a name and contains a list of ingredients)
     * 2. Create a datasource class (similar to MyPantry) where you will store the recipes
     * 3. In the datasource class, implement methods for saving a recipe and for getting all existing recipes - update
     * and delete are not necessary
     * 4. Create a service class (similar to PantryService) where you will interact with the datasource class
     * 5. Finally, create a controller and declare 2 endpoints:
     * 1. GET /recipe - returns the list of existing recipes
     * 2. POST /recipe - creates a new recipe based on the given name and list of ingredients (name
     * and list given in the request body) - if any ingredient is missing the name or the recipe name
     * is missing, respond with 400 BAD REQUEST
     * <p>
     * Here, create a new controller and a new service for interacting with the Recipes Service. The controller should
     * have 2 endpoints:
     * 1. GET /api/recipe/all - gets all existing recipes from the Recipes Service
     * 2. POST /api/recipe/new - receives a list of ingredients and a name for the recipe
     * - sends a request to the Recipes Service, passing the name and the list
     * - saves all ingredients locally - in MyPantry - only if the recipe was
     * saved successfully
     * Use RestTemplate for sending requests to the Recipes Service endpoints.
     * NOTE: In case there are errors when communicating with Recipes Service, 500 INTERNAL SERVER ERROR should be
     * returned.
     * <p>
     * The below tests should pass.
     */

    // External service call - SUCCESS
    @Test
    public void shouldSaveAndReturnRecipeIfSuccessful() throws Exception {
        String recipeName = "Classic omelette";
        List<Ingredient> ingredients = Stream.of(
                new Ingredient("Eggs", 3, "pieces"),
                new Ingredient("Cheese", 200, "g"),
                new Ingredient("Bacon", 90, "g")
        ).collect(Collectors.toList());
        CreateRecipeRequest request = new CreateRecipeRequest(recipeName, ingredients);

        this.mockMvc.perform(post("/api/recipe/new").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(recipeName));

        this.mockMvc.perform(get("/api/recipe/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].name").value(contains(recipeName)));
    }

    // External service call - 500 INTERNAL SERVER ERROR
    @Test
    public void shouldReturn500InternalServerErrorIfRecipesServiceReturnsErrors() throws Exception {
        List<Ingredient> ingredients = Stream.of(
                new Ingredient("Eggs", 3, "pieces"),
                new Ingredient("Cheese", 200, "g"),
                new Ingredient("Bacon", 90, "g")
        ).collect(Collectors.toList());
        CreateRecipeRequest request = new CreateRecipeRequest(null, ingredients);

        this.mockMvc.perform(post("/api/recipe/new").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isInternalServerError());
    }
}
