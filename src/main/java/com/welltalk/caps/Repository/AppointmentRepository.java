package com.welltalk.caps.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.welltalk.caps.Entity.AppointmentEntity;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Integer> {
	List<AppointmentEntity> findByUseridAndDecision(int userid, boolean decision);
	 List<AppointmentEntity> findByUserid(int userid);
	 List<AppointmentEntity> findByDecision(boolean decision);





}
