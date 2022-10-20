package com.maplemegan.cozycuppa.mapper;

import com.maplemegan.cozycuppa.dto.CountryDto;
import com.maplemegan.cozycuppa.entities.Country;

public class CountryMapper {
	
	public CountryDto toCountryDto(Country country) {
		CountryDto cd= CountryDto.builder()
				.countryId(country.getCountryId()).countryCode(country.getCountryCode())
				.hasDrinks(country.getHasDrinks()).usersInCountry(country.getUsersInCountry())
				.drinksInCountry(country.getDrinksInCountry()).build();
		return cd;
	}
	
	public Country toCountryEnt(CountryDto country) {
		return Country .builder()
				.countryId(country.getCountryId()).countryCode(country.getCountryCode())
				.hasDrinks(country.getHasDrinks()).usersInCountry(country.getUsersInCountry())
				.drinksInCountry(country.getDrinksInCountry()).build();
	}

}
