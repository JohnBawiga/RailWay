package com.welltalk.caps.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.welltalk.caps.Entity.JournalEntity;
@Repository
public interface JournalRepository extends JpaRepository<JournalEntity, Integer> {
    List<JournalEntity> findByUserid(int userid);
}
