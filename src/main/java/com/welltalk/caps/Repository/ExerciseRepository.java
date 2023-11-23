package com.welltalk.caps.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.welltalk.caps.Entity.ExerciseEntity;



@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity,Integer> {

	List<ExerciseEntity> findByExercisetype(String exercisetype);
	List <ExerciseEntity> findByDifficulty(String difficulty);
	List<ExerciseEntity> findByExercisetypeAndDifficulty(String exercisetype, String difficulty);
}

