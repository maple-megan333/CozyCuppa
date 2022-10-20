package com.maplemegan.cozy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.maplemegan.cozycuppa.dto.DrinkDto;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.Try;
import com.maplemegan.cozycuppa.mapper.DrinkMapper;
import com.maplemegan.cozycuppa.repositories.CommentRepository;
import com.maplemegan.cozycuppa.repositories.CountryRepository;
import com.maplemegan.cozycuppa.repositories.DrinkRepository;
import com.maplemegan.cozycuppa.repositories.DrinkTypeRepository;
import com.maplemegan.cozycuppa.repositories.IngredientRepository;
import com.maplemegan.cozycuppa.repositories.InstructionRepository;
import com.maplemegan.cozycuppa.repositories.ReviewRepository;
import com.maplemegan.cozycuppa.repositories.TryRepository;
import com.maplemegan.cozycuppa.repositories.UserRepository;

import enums.TryType;


@Service
public class DrinkService {
	private UserRepository userRepo;
	private CountryRepository countryRepo;
	private IngredientRepository ingredRepo;
	private InstructionRepository instructRepo;
	private DrinkTypeRepository dTypeRepo;
	private TryRepository tryRepo;
	private CommentRepository commentRepo;
	private ReviewRepository drinkReviews;
	private DrinkRepository drinkRepo;
	public DrinkService(UserRepository userRepo, CountryRepository countryRepo, IngredientRepository ingredRepo,
			InstructionRepository instructRepo, DrinkTypeRepository dTypeRepo, TryRepository tryRepo,
			CommentRepository commentRepo, ReviewRepository drinkReviews, DrinkRepository drinkRepo) {
		this.userRepo = userRepo;
		this.countryRepo = countryRepo;
		this.ingredRepo = ingredRepo;
		this.instructRepo = instructRepo;
		this.dTypeRepo = dTypeRepo;
		this.tryRepo = tryRepo;
		this.commentRepo = commentRepo;
		this.drinkReviews = drinkReviews;
		this.drinkRepo=drinkRepo;
	}
	
	public void createDrink() {
		
	}
	
	public List<DrinkDto> findAllPostsById(Integer id){
		List<Drink> usersDrinks = drinkRepo.findByauthorId(id);
		return usersDrinks.stream().map(DrinkMapper::maptoDrinkDto)
                .collect(Collectors.toList());
		
	}
	
	public Drink findByDrinkId(Integer id) {
		Drink drink = drinkRepo.findById(id).get();
		return drink;
		//return DrinkMapper.maptoDrinkDto(drink);
	}
}