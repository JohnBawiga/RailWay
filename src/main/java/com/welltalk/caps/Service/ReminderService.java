package com.welltalk.caps.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welltalk.caps.Entity.ReminderEntity;
import com.welltalk.caps.Repository.ReminderRepository;

import java.util.List;

@Service
public class ReminderService {
    private final ReminderRepository reminderRepository;

    @Autowired
    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    public List<ReminderEntity> getAllReminders() {
        return reminderRepository.findAll();
    }
    
    public ReminderEntity getLastReminder() {
        // Use the repository to fetch the last reminder by ordering by reminderId in descending order
        return reminderRepository.findTopByOrderByReminderIdDesc();
    }

    // You can add more service methods here for other reminder-related operations
}
