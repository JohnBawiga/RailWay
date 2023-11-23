package com.welltalk.caps.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tbl_exercises")



public class ExerciseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exerciseid;
	private String exercisename;
	private String exercisetype;
	private String instructions;
	private String equipments;
	private String videodemo;
	private String difficulty;
	
	public ExerciseEntity() {}

	public ExerciseEntity(int exerciseid, String exercisename, String exercisetype, String instructions,
			String equipments, String videodemo, String difficulty) {
		super();
		this.exerciseid = exerciseid;
		this.exercisename = exercisename;
		this.exercisetype = exercisetype;
		this.instructions = instructions;
		this.equipments = equipments;
		this.videodemo = videodemo;
		this.difficulty = difficulty;
	}

	public int getExerciseid() {
		return exerciseid;
	}

	public void setExerciseid(int exerciseid) {
		this.exerciseid = exerciseid;
	}

	public String getExercisename() {
		return exercisename;
	}

	public void setExercisename(String exercisename) {
		this.exercisename = exercisename;
	}

	public String getExercisetype() {
		return exercisetype;
	}

	public void setExercisetype(String exercisetype) {
		this.exercisetype = exercisetype;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getEquipments() {
		return equipments;
	}

	public void setEquipments(String equipments) {
		this.equipments = equipments;
	}

	public String getVideodemo() {
		return videodemo;
	}

	public void setVideodemo(String videodemo) {
		this.videodemo = videodemo;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	
	
	

}


