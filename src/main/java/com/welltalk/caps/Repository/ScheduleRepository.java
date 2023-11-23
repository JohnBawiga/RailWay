package com.welltalk.caps.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.welltalk.caps.Entity.ScheduleEntity;

public interface ScheduleRepository extends JpaRepository<ScheduleEntity, Long> {

	List<ScheduleEntity> findAll();
    List<ScheduleEntity> findByUserid(String userid);


}