package com.maplemegan.cozycuppa.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.context.annotation.Bean;

import com.maplemegan.cozycuppa.entities.Comment;
import com.maplemegan.cozycuppa.entities.Country;
import com.maplemegan.cozycuppa.entities.DrinkType;
import com.maplemegan.cozycuppa.entities.Ingredient;
import com.maplemegan.cozycuppa.entities.Instruction;
import com.maplemegan.cozycuppa.entities.Review;
import com.maplemegan.cozycuppa.entities.Try;
import com.maplemegan.cozycuppa.entities.User;

import lombok.*;

@Data
@Builder
public class DrinkDto {
	private Integer drinkId;
	private User authorId;
	private String drinkName;
	private String drinkNotes;
	private String drinkImg;
	private Set<DrinkType> drinkType;
	private Set<Ingredient> ingredients;
	private Set<Instruction> instructions;
	private String makingNotes;
	private LocalDateTime dateDrinkPublished;
	private Country	drinkCountryId;
	private Set<Try> drinkTries;
	private Set<Comment> drinkComments;
	private Set<Review> drinkReviews;
	
}
