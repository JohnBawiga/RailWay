package com.welltalk.caps.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.welltalk.caps.Entity.ExerciseEntity;
import com.welltalk.caps.Service.ExerciseService;



@RestController
@RequestMapping("/exercises")
public class ExerciseController {
	
	@Autowired
	ExerciseService eserv;
	
	//CREATE
	@CrossOrigin
	@PostMapping("/postExercise")
	public ExerciseEntity insertExercise(@RequestBody ExerciseEntity exercise) {
		return eserv.insertExercise(exercise);
	}
	
	//READ ALL
	@GetMapping("/getAllExercises")
	public List<ExerciseEntity> getAllExercise(){
		return eserv.getAllExercise();
	}
	
	//READ BY TYPE
	@CrossOrigin
	@GetMapping("/getByExerciseType")
	public List<ExerciseEntity> findByType(@RequestParam String exercisetype) {
		return eserv.findByType(exercisetype);
	}
	
	//READ BY DIFFICULTY
	@GetMapping("/getByExerciseDifficulty")
	public List<ExerciseEntity> findByDifficulty(@RequestParam String difficulty) {
		return eserv.findByDifficulty(difficulty);
	}
	
	// READ BY TYPE AND DIFFICULTY
	@CrossOrigin
    @GetMapping("/getByExerciseTypeAndDifficulty")
    public List<ExerciseEntity> findByTypeAndDifficulty(
            @RequestParam String exercisetype,
            @RequestParam String difficulty) {
        return eserv.findByTypeAndDifficulty(exercisetype, difficulty);
    }
	
	//UPDATE
	@CrossOrigin
	@PutMapping("/putExercise")
	public ExerciseEntity putExercise(@RequestParam int exerciseid, @RequestBody ExerciseEntity newExerciseEntity)throws Exception{
		return eserv.putExercise(exerciseid, newExerciseEntity);
	}
	
	//DELETE
	@CrossOrigin
	@DeleteMapping("/deleteExercise/{exerciseid}")
	public String deleteExercise(@PathVariable int exerciseid) {
		return eserv.deleteExercise(exerciseid);
	}
}

