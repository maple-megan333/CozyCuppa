package com.maplemegan.cozycuppa.mapper;

import com.maplemegan.cozycuppa.dto.InstructionDto;
import com.maplemegan.cozycuppa.entities.Instruction;

public class InstructionsMapper {
	public InstructionDto mapToDto(Instruction instruct) {
		InstructionDto thisInstrcut = InstructionDto.builder()
				.instructionDrinkId(instruct.getInstructionDrinkId())
				.instructionId(instruct.getInstructionId()).step(instruct.getStep())
				.step_instruction(instruct.getStep_instruction()).build();
		return thisInstrcut;
	}
	
	public static Instruction maptoEntity(InstructionDto instructDto) {
		return Instruction.builder().instructionDrinkId(instructDto.getInstructionDrinkId())
				.instructionId(instructDto.getInstructionId()).step(instructDto.getStep())
				.step_instruction(instructDto.getStep_instruction()).build();

	}

}
