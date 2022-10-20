package com.maplemegan.cozycuppa.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maplemegan.cozy.services.CountryServices;
import com.maplemegan.cozy.services.DrinkService;
import com.maplemegan.cozy.services.IngredientServices;
import com.maplemegan.cozy.services.InstructionService;
import com.maplemegan.cozy.services.ReviewService;
import com.maplemegan.cozy.services.TryService;
import com.maplemegan.cozy.services.UserServices;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.Review;
import com.maplemegan.cozycuppa.entities.User;
import com.maplemegan.cozycuppa.repositories.DrinkTypeRepository;
import com.maplemegan.cozycuppa.repositories.ReviewRepository;


//Here I will manage the main functionality for my reviews.
@Controller
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired
	private DrinkService drinkService;
	@Autowired
	private UserServices userServ;
	@Autowired
	private DrinkTypeRepository dTypeRepo;
	private ReviewService reviewServ;
	
	public ReviewController(DrinkService drinkService, UserServices userServ, DrinkTypeRepository dTypeRepo,
			ReviewService reviewServ) {
		super();
		this.drinkService = drinkService;
		this.userServ = userServ;
		this.dTypeRepo = dTypeRepo;
		this.reviewServ = reviewServ;
	}

	
	

}
