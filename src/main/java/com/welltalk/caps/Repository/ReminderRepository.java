package com.welltalk.caps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.welltalk.caps.Entity.ReminderEntity;

@Repository
public interface ReminderRepository extends JpaRepository<ReminderEntity, Long> {
    // You can add custom query methods here if needed
    ReminderEntity findTopByOrderByReminderIdDesc();

}

