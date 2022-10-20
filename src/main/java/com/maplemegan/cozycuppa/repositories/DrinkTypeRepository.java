package com.maplemegan.cozycuppa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.maplemegan.cozycuppa.entities.DrinkType;

public interface DrinkTypeRepository extends JpaRepository<DrinkType, Integer>{
	
}
