package com.welltalk.caps.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.welltalk.caps.Repository.ScheduleRepository;
import com.welltalk.caps.Service.ScheduleService;
import com.welltalk.caps.Entity.ScheduleEntity;
@RestController
@CrossOrigin(origins = "http://localhost:19006/")

public class ScheduleController {
    private final ScheduleRepository scheduleRepository;
    private final ScheduleService scheduleService;
    
    @Autowired
    public ScheduleController(ScheduleRepository scheduleRepository, ScheduleService scheduleService) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/getAllSchedules")
    public List<ScheduleEntity> getAllSchedules() {
        return scheduleRepository.findAll();
    }
   
    

    @GetMapping("/schedules")
    public List<ScheduleEntity> getSchedulesByUserId(@RequestParam String userid) {
        return scheduleService.getSchedulesByUserId(userid);
    }
    
    
}
