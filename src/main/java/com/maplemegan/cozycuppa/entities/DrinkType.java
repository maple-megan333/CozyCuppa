package com.maplemegan.cozycuppa.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Drink_types")
public class DrinkType {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "Type_Id")
	private Integer drinkTypeId;
	
	@Column(name="Type_name")
	private String drinkTypeName;
	
	

	public Integer getDrinkTypeId() {
		return drinkTypeId;
	}

	public void setDrinkTypeId(Integer drinkTypeId) {
		this.drinkTypeId = drinkTypeId;
	}

	public String getDrinkTypeName() {
		return drinkTypeName;
	}

	public void setDrinkTypeName(String drinkTypeName) {
		this.drinkTypeName = drinkTypeName;
	}

	@Override
	public String toString() {
		return "DrinkType [drinkTypeId=" + drinkTypeId + ", drinkTypeName=" + drinkTypeName + "]";
	}
	
	
}
