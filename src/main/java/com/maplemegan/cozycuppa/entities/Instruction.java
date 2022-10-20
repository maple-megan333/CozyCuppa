package com.maplemegan.cozycuppa.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
@Table(name="Instructions")
public class Instruction {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "Instruction_Id")
	private Integer instructionId;
	
	@ManyToOne
    @JoinColumn(name = "instruction_Drink", referencedColumnName = "Drink_Id")
	private Drink instructionDrinkId;
	
	@Column(name="Step_num")
	private Integer step;
	
	@Column(name="Instruction")
	private String step_instruction;
	

	public Instruction() {
	}

	public Integer getInstructionId() {
		return instructionId;
	}

	public void setInstructionId(Integer instructionId) {
		this.instructionId = instructionId;
	}

	public Drink getInstructionDrinkId() {
		return instructionDrinkId;
	}

	public void setInstructionDrinkId(Drink instructionDrinkId) {
		this.instructionDrinkId = instructionDrinkId;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public String getStep_instruction() {
		return step_instruction;
	}

	public void setStep_instruction(String step_instruction) {
		this.step_instruction = step_instruction;
	}

	@Override
	public String toString() {
		return "Instruction [instructionId=" + instructionId + ", instructionDrinkId=" + instructionDrinkId + ", step="
				+ step + ", step_instruction=" + step_instruction + "]";
	}
	
	
}
