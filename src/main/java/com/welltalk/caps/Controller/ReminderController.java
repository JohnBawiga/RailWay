package com.welltalk.caps.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.welltalk.caps.Entity.ReminderEntity;
import com.welltalk.caps.Service.ReminderService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:19006/")

public class ReminderController {
    private final ReminderService reminderService;

    @Autowired
    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping("/reminderall")
    public List<ReminderEntity> getAllReminders() {
        List<ReminderEntity> reminders = reminderService.getAllReminders();
        return reminders;
    }
    @GetMapping("/last")
    public ReminderEntity getLastReminder() {
        return reminderService.getLastReminder();
    }
}
