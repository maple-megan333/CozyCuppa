package com.maplemegan.cozycuppa.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.Review;


public interface DrinkRepository extends JpaRepository<Drink, Integer> {
	List<Drink> findByauthorId(Integer authorID);
	List<Drink> findBydrinkCountryId(Integer drinkCountryId);
	@Query( value = "select distinct d.* from drinks d " +
			" join assigned_drink_types t on d.drink_id = t.drink" +
            " where (:countryId = 0 OR d.drink_country = :countryId) AND (COALESCE(:typeIds) IS NULL OR t.type IN (:typeIds))", 
            nativeQuery = true)
	List<Drink> findForSearch(@Param("countryId")Integer countryId,@Param("typeIds") List<Integer> typeIds);
}
