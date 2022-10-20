package com.maplemegan.cozy.services;

import org.springframework.stereotype.Service;

import com.maplemegan.cozycuppa.dto.InstructionDto;
import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.Instruction;
import com.maplemegan.cozycuppa.mapper.InstructionsMapper;
import com.maplemegan.cozycuppa.repositories.DrinkRepository;
import com.maplemegan.cozycuppa.repositories.InstructionRepository;

@Service
public class InstructionService {
	private DrinkRepository drinkRepo;
	private InstructionRepository instructRepo;
	
	public InstructionService(DrinkRepository drinkRepo, InstructionRepository instructRepo) {
		this.drinkRepo = drinkRepo;
		this.instructRepo = instructRepo;
	}

	public Instruction findInstructByDrink(Integer instructionDrinkId) {
		return this.instructRepo.findByinstructionDrinkId(instructionDrinkId);
	}
	
	public void createInstruction(Drink drink, InstructionDto dto) {
		Instruction instructThis = InstructionsMapper.maptoEntity(dto);
		instructThis.setInstructionDrinkId(drink);
		instructRepo.save(instructThis);
	}

}
