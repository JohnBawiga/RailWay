package com.welltalk.caps.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.welltalk.caps.Entity.UserEntity;
import com.welltalk.caps.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> signup(UserEntity user) {
        // Check if email or studentID is already registered
        boolean existingUserByEmail = userRepository.existsByEmail(user.getEmail());
        boolean existingUserByStudentID = userRepository.existsByStudentID(user.getStudentID());

        if (existingUserByEmail) {
            return new ResponseEntity<>("Email already registered", HttpStatus.CONFLICT);
        }

        if (existingUserByStudentID) {
            return new ResponseEntity<>("Student ID already registered", HttpStatus.CONFLICT);
        }

        // Save the new user
        userRepository.save(user);
        return new ResponseEntity<>("Registration successful", HttpStatus.OK);
    }

    public UserEntity getUserByStudentID(String studentID) {
        // Implement logic to fetch user data by studentID from the repository
        return userRepository.findByStudentID(studentID);
    }
    public UserEntity getUserByStudentID1(String studentID) {
        // Implement logic to fetch user data by studentID from the repository
        return userRepository.findByStudentID(studentID);
    }

    public UserEntity insertUser(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Search by studentID
    public UserEntity findByStudentID(String studentID) {
        if (userRepository.findByStudentID(studentID) != null)
            return userRepository.findByStudentID(studentID);
        else
            return null;
    }
    public UserEntity getUserByUserId(Long userid) {
        // Implement logic to fetch user data by userid from the repository
        return userRepository.findByUserid(userid);
}

}
