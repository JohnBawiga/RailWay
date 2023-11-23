package com.welltalk.caps.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welltalk.caps.Entity.ScheduleEntity;
import com.welltalk.caps.Repository.ScheduleRepository;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<ScheduleEntity> getSchedulesByUserId(String userid) {
        return scheduleRepository.findByUserid(userid);
    }
}