package com.maplemegan.cozycuppa.dto;
import com.maplemegan.cozycuppa.entities.Drink;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstructionDto {
	private Integer instructionId;
	private Integer step;
	private String step_instruction;
	private Drink instructionDrinkId;
}
