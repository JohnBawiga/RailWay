package com.welltalk.caps.Controller;


import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.welltalk.caps.Entity.ForgotPasswordRequest;
import com.welltalk.caps.Entity.JournalEntity;
import com.welltalk.caps.Entity.PasswordUpdateRequest;
import com.welltalk.caps.Entity.UserEntity;
import com.welltalk.caps.Repository.UserRepository;
import com.welltalk.caps.Service.EmailService;
import com.welltalk.caps.Service.UserService;

	@RestController
	@CrossOrigin(origins = "http://localhost:19006")
	public class UserController {

	    @Autowired
	    private UserService userService; // Autowire the UserRepository
	    
	    @Autowired
	    private UserRepository userRepository;
	    
	    @Autowired
	    private EmailService emailService;

	    
	    @GetMapping("/getAllUser")
	    public List<UserEntity> getAllUser() {
	        return userRepository.findAll();
	    }
	    
	    @PostMapping("/signup")
	    public ResponseEntity<String> signup(@RequestBody UserEntity user) {
	        return userService.signup(user); // Call the non-static method on the instance
	    }
	    
	    @GetMapping("/user/{userid}")
	    public ResponseEntity<UserEntity> getUserByUserId(@PathVariable Long userid) {
	        // Call the service method to fetch user data by userid
	        UserEntity user = userService.getUserByUserId(userid);
	        if (user != null) {
	            return ResponseEntity.ok(user);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    @GetMapping("/userGet/{userid}")
	    public ResponseEntity<UserEntity> getUserById(@PathVariable("userid") long userid) {
	        Optional<UserEntity> user = userRepository.findById(userid);
	        return user.map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	    
	    @PutMapping("/user/{userid}")
	    public ResponseEntity<String> updateUser(@PathVariable("userid") long userid, @RequestBody UserEntity updatedEntry) {
	        Optional<UserEntity> user = userRepository.findById(userid);
	        if (user.isPresent()) {
	            UserEntity existingEntry = user.get();

	            existingEntry.setCourse(updatedEntry.getCourse());
	            existingEntry.setEmail(updatedEntry.getEmail());
	            existingEntry.setFirstName(updatedEntry.getFirstName());
	            existingEntry.setLastName(updatedEntry.getLastName());
	            existingEntry.setPassword(updatedEntry.getPassword());
	            existingEntry.setPhoneNumber(updatedEntry.getPhoneNumber());
	         
	            userRepository.save(existingEntry);
	            return ResponseEntity.ok("User's profile has been updated successfully!");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    @DeleteMapping("/user/{userid}")
	    public ResponseEntity<String> deleteUser(@PathVariable("userid")long userid) {
	        Optional<UserEntity> user = userRepository.findById(userid);
	        if (user.isPresent()) {
	        	userRepository.deleteById(userid);
	            return ResponseEntity.ok("User has deleted successfully!");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    @GetMapping("/getByUserid")
	    public ResponseEntity findByUserid(
	            @RequestParam(name = "userid", required = false, defaultValue = "0") Long userid,
	            @RequestParam(name = "password", required = false, defaultValue = "0") String password	
	    ) {
	
	        UserEntity user = userService.findByUserid(userid);

	        if (user != null && user.getPassword().equals(password)) {
	            // Log-in successful
	            return ResponseEntity.ok(user);
	        } else {
	            // Log-in invalid
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Log-in invalid");
	        }
	    }

	    @PostMapping("/forgotpassword")
	    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequest request) {
	    	// Generate a reset token
	        String resetToken = generateResetToken();
	        
	        // Send the reset password email
	        emailService.sendEmail(request.getEmail(), "WellTalk Password Reset Request", "Your reset token: " + resetToken);

	        // Return a success response
	        return ResponseEntity.ok("Password reset email sent successfully");
	    }

		private String generateResetToken() {
		       // Define the length of the reset token
		       int tokenLength = 32; // You can adjust the length as needed

		       // Generate a secure random token
		       SecureRandom secureRandom = new SecureRandom();
		       byte[] tokenBytes = new byte[tokenLength];
		       secureRandom.nextBytes(tokenBytes);

		       // Encode the token as a base64 string
		       String resetToken = Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);

		       return resetToken;
		}
		 
		@PutMapping("/updatepassword")
		public ResponseEntity<String> updatePassword(@RequestBody PasswordUpdateRequest request) {
		    // Validate the request
		    if (request == null || request.getEmail() == null || request.getNewPassword() == null) {
		        return ResponseEntity.badRequest().body("Invalid request");
		    }

		    // Check if the user exists based on the provided email
		    UserEntity user = userRepository.findByEmail(request.getEmail());

		    if (user == null) {
		        return ResponseEntity.notFound().build();
		    }

		    // Update the user's password
		    user.setPassword(request.getNewPassword());
		    userRepository.save(user);

		    // Return a success response
		    return ResponseEntity.ok("Password updated successfully");
		}


	    }