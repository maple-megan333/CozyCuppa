package com.maplemegan.cozycuppa.entities;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
@Table(name="Ingredients")
public class Ingredient {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "Ingredient_Id")
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "Ingredient_Drink", referencedColumnName = "Drink_Id")
	private Drink ingredientDrinkId;
	
	@Column(name="Ingredient")
	private String ingredient;
	
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", ingredientDrinkId=" + ingredientDrinkId + ", ingredient=" + ingredient + "]";
	}

	public Ingredient() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Drink getIngredientDrinkId() {
		return ingredientDrinkId;
	}

	public void setIngredientDrinkId(Drink ingredientDrinkId) {
		this.ingredientDrinkId = ingredientDrinkId;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

}
