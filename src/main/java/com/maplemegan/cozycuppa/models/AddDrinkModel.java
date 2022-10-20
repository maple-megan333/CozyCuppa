package com.maplemegan.cozycuppa.models;

import java.util.List;

import com.maplemegan.cozycuppa.entities.Ingredient;

public class AddDrinkModel {
	private String name;
	private String drinkNotes;
	private Integer countryId;
	private List<String> typeIds;
	private List<String> ingredients;
	private List<String> instructions;
	private String additionalNotes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDrinkNotes() {
		return drinkNotes;
	}
	public void setDrinkNotes(String drinkNotes) {
		this.drinkNotes = drinkNotes;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public List<String> getTypeIds() {
		return typeIds;
	}
	public void setTypeIds(List<String> typeIds) {
		this.typeIds = typeIds;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	public List<String> getInstructions() {
		return instructions;
	}
	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}
	public String getAdditionalNotes() {
		return additionalNotes;
	}
	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

}
