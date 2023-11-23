
package com.welltalk.caps.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.welltalk.caps.Repository.GuidanceRepository;


import java.util.List;
import java.util.Optional;

import com.welltalk.caps.Entity.GuidanceEntity;


@RestController
@CrossOrigin(origins = "http://localhost:19006/")
public class GuidanceController {

    private GuidanceRepository guidanceRepository;


    @Autowired
    public GuidanceController(GuidanceRepository guidanceRepository) {
        this.guidanceRepository = guidanceRepository;
    }
    
    
    @GetMapping("/getAllAppointment")
    public List<GuidanceEntity> getAllAppointment() {
        return guidanceRepository.findAll();
    }
    
   
   

   
    
}