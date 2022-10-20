package com.maplemegan.cozycuppa.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.maplemegan.cozycuppa.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
 List<Ingredient> findByingredientDrinkId(Integer ingredientDrinkId);
}
