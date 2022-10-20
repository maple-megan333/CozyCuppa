package com.maplemegan.cozycuppa.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.Ingredient;
import com.maplemegan.cozycuppa.repositories.IngredientRepository;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
	private IngredientRepository ingredientRepo;

	public IngredientController(IngredientRepository ingredientRepo) {

		this.ingredientRepo = ingredientRepo;
	}
	
	@GetMapping("/{drinkId}")
	public List<Ingredient> getDrinksIngredients(Integer ingredientDrinkId){
		return this.ingredientRepo.findByingredientDrinkId(ingredientDrinkId);
	}
	
	
	

}
