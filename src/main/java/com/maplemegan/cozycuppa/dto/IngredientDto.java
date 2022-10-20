package com.maplemegan.cozycuppa.dto;

import java.time.LocalDateTime;
import java.util.Set;

import com.maplemegan.cozycuppa.entities.Comment;
import com.maplemegan.cozycuppa.entities.Country;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.DrinkType;
import com.maplemegan.cozycuppa.entities.Ingredient;
import com.maplemegan.cozycuppa.entities.Instruction;
import com.maplemegan.cozycuppa.entities.Review;
import com.maplemegan.cozycuppa.entities.Try;
import com.maplemegan.cozycuppa.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientDto {
	private Integer id;
	private Drink ingredientDrinkId;
	private String ingredient;
}
