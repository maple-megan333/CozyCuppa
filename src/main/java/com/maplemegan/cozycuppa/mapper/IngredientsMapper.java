package com.maplemegan.cozycuppa.mapper;

import com.maplemegan.cozycuppa.dto.IngredientDto;
import com.maplemegan.cozycuppa.entities.Ingredient;

public class IngredientsMapper {
	
	public IngredientDto mapToDto(Ingredient thisIn) {
		IngredientDto thisDto = IngredientDto.builder().id(thisIn.getId())
				.ingredientDrinkId(thisIn.getIngredientDrinkId()).ingredient(thisIn.getIngredient()).build();
		return thisDto;
	}
	
	public static Ingredient mapToentity(IngredientDto thisIn) {
		return Ingredient.builder().id(thisIn.getId())
				.ingredientDrinkId(thisIn.getIngredientDrinkId()).ingredient(thisIn.getIngredient()).build();
		
	}

}
