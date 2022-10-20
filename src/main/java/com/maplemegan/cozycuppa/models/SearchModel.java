package com.maplemegan.cozycuppa.models;

import java.util.List;

import com.maplemegan.cozycuppa.entities.Ingredient;

public class SearchModel {

	private Integer countryId;
	private List<String> typeIds;

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
}
