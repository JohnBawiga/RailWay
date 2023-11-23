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
	        // Check if email or userid is already registered
	        boolean existingUserbyEmail = userRepository.existsByEmail(user.getEmail());
	        boolean existingUserbyId = userRepository.existsByUserid(user.getUserid());
	        
	        if (existingUserbyEmail) {
	            return new ResponseEntity<>("Email already registered", HttpStatus.CONFLICT);
	        }

	        if (existingUserbyId) {
	            return new ResponseEntity<>("User ID already registered", HttpStatus.CONFLICT);
	        }
	        // Save the new user
	        userRepository.save(user);
	        return new ResponseEntity<>("Registration successful", HttpStatus.OK);
	    }
	    public UserEntity getUserByUserId(Long userid) {
	        // Implement logic to fetch user data by userid from the repository
	        return userRepository.findByUserid(userid);
	}
	    public UserEntity insertUser(UserEntity user) {
			return userRepository.save(user);
		}
		
		public List<UserEntity> getAllUsers(){
			return userRepository.findAll();
		}
		
		//Search by userid
		public UserEntity findByUserid(Long userid) {
			if (userRepository.findByUserid(userid) !=null)
				return userRepository.findByUserid(userid);
			else 
				return null;
		}

}