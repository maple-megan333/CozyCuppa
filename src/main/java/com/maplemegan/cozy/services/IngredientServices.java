package com.maplemegan.cozy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maplemegan.cozycuppa.dto.IngredientDto;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.Ingredient;
import com.maplemegan.cozycuppa.mapper.IngredientsMapper;
import com.maplemegan.cozycuppa.repositories.DrinkRepository;
import com.maplemegan.cozycuppa.repositories.IngredientRepository;

@Service
public class IngredientServices {
	
	private DrinkRepository drinkRepo;
	private IngredientRepository inRepo;
	public IngredientServices(DrinkRepository drinkRepo, IngredientRepository inRepo) {
		this.drinkRepo = drinkRepo;
		this.inRepo = inRepo;
	}
	
	public void createNew(Drink drink, IngredientDto inDto) {
		Ingredient newIngredient = IngredientsMapper.mapToentity(inDto);
		newIngredient.setIngredientDrinkId(drink);
		inRepo.save(newIngredient);
	}
	
	public List<Ingredient> findDrinkIngredients(Integer drinkId){
		 return inRepo.findByingredientDrinkId(drinkId);
	}

}
