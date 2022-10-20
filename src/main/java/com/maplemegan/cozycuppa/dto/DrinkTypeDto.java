package com.maplemegan.cozycuppa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DrinkTypeDto {
	private Integer drinkTypeId;
	private String drinkTypeName;
}
