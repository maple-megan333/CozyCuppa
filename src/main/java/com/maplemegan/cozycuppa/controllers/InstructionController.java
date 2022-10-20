package com.maplemegan.cozycuppa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maplemegan.cozycuppa.entities.Drink;
import com.maplemegan.cozycuppa.entities.Instruction;
import com.maplemegan.cozycuppa.entities.Review;
import com.maplemegan.cozycuppa.repositories.InstructionRepository;

@RestController
@RequestMapping("/instructions")
public class InstructionController {
	
	@Autowired
	private InstructionRepository instructionRepo;

	public InstructionController(InstructionRepository instructionRepo) {
		this.instructionRepo = instructionRepo;
	}
	
	//Need to come back here once I figure out the form stuff and iterate through all instructions to get step#

}
