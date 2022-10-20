package com.maplemegan.cozycuppa.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maplemegan.cozycuppa.entities.Country;
import com.maplemegan.cozycuppa.repositories.CountryRepository;

@RestController
@RequestMapping("/countries")
public class CountryController {
	@Autowired
	private final CountryRepository countryRepo;
	
	public CountryController(final CountryRepository countryRepo){
		this.countryRepo=countryRepo;
	}
	
	@GetMapping("/")
	  public Iterable<Country> getAllCountries() {
	    return this.countryRepo.findAll();
	  }
	
	@PostMapping("/")
	public Country createCountry(@RequestBody Country country){
		Country newCountry = this.countryRepo.save(country);
		return newCountry;
		
	}
	
	/*
	@RequestMapping(path = "/{countryCode}")
	public ResponseEntity<Country> findbycountryCode(@PathVariable String countryCode) {
	       try {
	    	   Optional<Country> opts = Optional.of(countryRepo.findBycountryCode(countryCode));

	           if (!opts.isPresent()) {
	               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	           }
	           return new ResponseEntity<>(opts.get(), HttpStatus.OK);
	       } catch (Exception e) {
	           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	       }
	   }
	
	*/
	

}
