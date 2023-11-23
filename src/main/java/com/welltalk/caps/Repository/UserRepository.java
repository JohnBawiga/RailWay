package com.welltalk.caps.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.welltalk.caps.Entity.UserEntity;

@Repository

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	boolean existsByEmail(String email);
	boolean existsByUserid(Long userid);
	UserEntity findByUserid(Long userid);
	UserEntity findByEmail(String email);


}
