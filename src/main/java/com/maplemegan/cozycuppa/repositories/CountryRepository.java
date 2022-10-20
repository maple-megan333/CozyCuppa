package com.maplemegan.cozycuppa.repositories;
import com.maplemegan.cozycuppa.entities.Country;
import com.maplemegan.cozycuppa.entities.Drink;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{
	Country findBycountryCode(String countryCode);
	
	@Query( value = "select distinct * from countries c " +
            "join drinks d " +
            "on c.country_id = d.drink_country", 
            nativeQuery = true)
    List<Country> findByHasDrinks();
}
