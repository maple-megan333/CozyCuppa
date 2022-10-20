package com.maplemegan.cozycuppa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maplemegan.cozycuppa.repositories.DrinkTypeRepository;

@RestController
@RequestMapping("/drinkTypes")
public class DrinkTypeController {
	@Autowired
	private DrinkTypeRepository drinkTypeRepo;

	public DrinkTypeController(DrinkTypeRepository drinkTypeRepo) {
		super();
		this.drinkTypeRepo = drinkTypeRepo;
	}
	
}
