package com.maplemegan.cozy.services;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.maplemegan.cozycuppa.entities.Country;
import com.maplemegan.cozycuppa.repositories.CountryRepository;
import com.maplemegan.cozycuppa.repositories.DrinkRepository;
import com.maplemegan.cozycuppa.repositories.UserRepository;

@Service
public class CountryServices {
	private DrinkRepository drinkRepo;
	private UserRepository userRepo;
	private CountryRepository countryRepo;
	
	public CountryServices(DrinkRepository drinkRepo, UserRepository userRepo, CountryRepository countryRepo) {
		this.drinkRepo = drinkRepo;
		this.userRepo = userRepo;
		this.countryRepo = countryRepo;
	}
	
	public List<Country> currentlyHasDrinks(){
		 List<Country> currentlyHasDrinks = countryRepo.findByHasDrinks();
		 return currentlyHasDrinks;
	}
	
	public Country findByCountryCode(String countryCode) {
		return countryRepo.findBycountryCode(countryCode);
	}
	
	public Country findById(Integer Id) {
		return countryRepo.findById(Id).get();
	}
	public List<Country> findAll(){
		return countryRepo.findAll();
	}
	
}
