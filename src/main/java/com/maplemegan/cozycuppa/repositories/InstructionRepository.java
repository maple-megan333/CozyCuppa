package com.maplemegan.cozycuppa.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.maplemegan.cozycuppa.entities.Instruction;

public interface InstructionRepository extends JpaRepository<Instruction, Integer> {
	Instruction findByinstructionDrinkId(Integer instructionDrinkId);

}
