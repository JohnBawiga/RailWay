package com.welltalk.caps.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.welltalk.caps.Entity.AppointmentEntity;
import com.welltalk.caps.Repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	
	public Iterable<AppointmentEntity> getRequest(){
		return appointmentRepository.findAll();
	}
	
	public ResponseEntity deleteRequest(int makeappointmentid) {
		appointmentRepository.deleteById(makeappointmentid);
		return ResponseEntity.ok("Request deleted successfully");
	}
	
	public ResponseEntity updateAppointment(int makeappointmentid, String stringToken) {
		AppointmentEntity appointmentUpdate = appointmentRepository.findById(makeappointmentid).get();
		
		if(appointmentUpdate.getDecision() == null) {
			appointmentUpdate.setDecision(true);
			appointmentRepository.save(appointmentUpdate);
			return ResponseEntity.ok("Request Accepted");
		}else {
			return ResponseEntity.ok("Request Already Accepted");
		}
	}
	
}
