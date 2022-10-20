package com.maplemegan.cozycuppa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.Try;
import com.maplemegan.cozycuppa.entities.User;
import com.maplemegan.cozycuppa.repositories.TryRepository;

import enums.TryType;


@RestController
@RequestMapping("/tries")
public class TryController {
	/*Here I am going to put a helper method to check if user has tried this drink.
	 * if the user has tried just update the method to the current try type selection
	 * Further this should just refresh the drink page*/
	@Autowired
	private TryRepository tryRepo;
	
	public TryController(TryRepository tryRepo) {
		this.tryRepo = tryRepo;
	}


	@GetMapping("/")
	public Iterable<Try> findAllTries(){
		return this.tryRepo.findAll();
	}
	
	@GetMapping("/{drinkId}")
	public List<Try> getDrinkTries(@PathVariable Integer drinkTryId){
		return tryRepo.findBydrinkTryId(drinkTryId);
	}
	
	
	
	
	
	
	
	
}
