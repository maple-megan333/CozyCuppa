package com.maplemegan.cozycuppa.mapper;

import com.maplemegan.cozycuppa.dto.DrinkDto;
import com.maplemegan.cozycuppa.entities.Drink;

public class DrinkMapper {
	// map drink entity to drink dto
	public static DrinkDto maptoDrinkDto(Drink drink) {
		DrinkDto drinkDto = DrinkDto.builder().drinkNotes(drink.getDrinkNotes())
				.drinkId(drink.getDrinkId()).authorId(drink.getAuthorId())
				.drinkName(drink.getDrinkName()).drinkImg(drink.getDrinkImg())
				.drinkType(drink.getDrinkType()).makingNotes(drink.getMakingNotes())
				.dateDrinkPublished(drink.getDateDrinkPublished()).drinkCountryId(drink.getDrinkCountry())
				.drinkTries(drink.getDrinkTries()).drinkComments(drink.getDrinkComments()).drinkReviews(drink.getDrinkReviews())
				.ingredients(drink.getIngredients()).instructions(drink.getInstructions()).build();
		return drinkDto;
		}
//mapdto to post entity
	public static Drink maptoDrink (DrinkDto drinkDto) {
		return Drink.builder().drinkNotes(drinkDto.getDrinkNotes()).drinkId(drinkDto.getDrinkId()).authorId(drinkDto.getAuthorId())
				.drinkName(drinkDto.getDrinkName()).drinkImg(drinkDto.getDrinkImg())
				.drinkType(drinkDto.getDrinkType()).makingNotes(drinkDto.getMakingNotes())
				.dateDrinkPublished(drinkDto.getDateDrinkPublished()).drinkCountryId(drinkDto.getDrinkCountryId())
				.drinkTries(drinkDto.getDrinkTries()).drinkComments(drinkDto.getDrinkComments()).drinkReviews(drinkDto.getDrinkReviews())
				.ingredients(drinkDto.getIngredients()).instructions(drinkDto.getInstructions()).build();
	} 
}
