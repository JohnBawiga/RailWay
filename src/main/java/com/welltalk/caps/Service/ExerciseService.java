package com.welltalk.caps.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welltalk.caps.Entity.ExerciseEntity;
import com.welltalk.caps.Repository.ExerciseRepository;


@Service
public class ExerciseService {
	
	@Autowired
	ExerciseRepository erepo;
	
	//CREATE
	public ExerciseEntity insertExercise(ExerciseEntity exercise) {
	return erepo.save(exercise);	
	}
	
	//READ
	public List<ExerciseEntity> getAllExercise(){
		return erepo.findAll();
	}
	
	//READ BY TYPE
	public List<ExerciseEntity> findByType(String exercisetype) {
		if(erepo.findByExercisetype(exercisetype) !=null)
			return erepo.findByExercisetype(exercisetype);
		else
			return null;
	}
	
	//READ BY DIFFICULTY
	public List<ExerciseEntity> findByDifficulty(String difficulty) {
		if(erepo.findByDifficulty(difficulty) !=null)
			return erepo.findByDifficulty(difficulty);
		else
			return null;
	}
	
	// READ BY TYPE AND DIFFICULTY
    public List<ExerciseEntity> findByTypeAndDifficulty(String exercisetype, String difficulty) {
        return erepo.findByExercisetypeAndDifficulty(exercisetype, difficulty);
    }
	
	//UPDATE
	
	public ExerciseEntity putExercise(int exerciseid, ExerciseEntity newExerciseDetails)throws Exception{
		ExerciseEntity exercise= new ExerciseEntity();
		
		try {
			exercise = erepo.findById(exerciseid).get();
			exercise.setExercisename(newExerciseDetails.getExercisename());
			exercise.setExercisetype(newExerciseDetails.getExercisetype());
			exercise.setInstructions(newExerciseDetails.getInstructions());
			exercise.setEquipments(newExerciseDetails.getEquipments());
			exercise.setVideodemo(newExerciseDetails.getVideodemo());
			exercise.setDifficulty(newExerciseDetails.getDifficulty());
			
			return erepo.save(exercise);
		}catch(NoSuchElementException nex) {
			throw new Exception("Exercise ID" + exerciseid + "does not exist");
		}
	}
	
	//DELETE
	public String deleteExercise(int exerciseid) {
		String msg;
		if(erepo.findById(exerciseid) !=null) {
			erepo.deleteById(exerciseid);
			msg="Exercise ID number" + exerciseid + "is successful deleted";
		}else
			msg="Exercise ID number" + exerciseid + "is successful deleted";
		return msg;
	}

}

