package com.welltalk.caps.Controller;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.welltalk.caps.Entity.ForgotPasswordRequest;
import com.welltalk.caps.Entity.PasswordUpdateRequest;
import com.welltalk.caps.Entity.UserEntity;
import com.welltalk.caps.Repository.UserRepository;
import com.welltalk.caps.Service.EmailService;
import com.welltalk.caps.Service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:19006/")
public class UserController {

    @Autowired
    private UserService userService;

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
        return userService.signup(user);
    }

    @GetMapping("/user/{studentID}")
    public ResponseEntity<UserEntity> getUserByStudentID(@PathVariable String studentID) {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByStudentID(studentID));
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/userGet/{userid}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("userid") long userid) {
        Optional<UserEntity> user = userRepository.findById(userid);
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/user/{studentID}")
    public ResponseEntity<String> updateStudent(@PathVariable("studentID") String studentID, @RequestBody UserEntity updatedEntry) {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByStudentID(studentID));
        if (user.isPresent()) {
            UserEntity existingEntry = user.get();

            existingEntry.setCourse(updatedEntry.getCourse());
            existingEntry.setEmail(updatedEntry.getEmail());
            existingEntry.setFirstName(updatedEntry.getFirstName());
            existingEntry.setLastName(updatedEntry.getLastName());
            existingEntry.setPassword(updatedEntry.getPassword());
            existingEntry.setPhoneNumber(updatedEntry.getPhoneNumber());
            existingEntry.setStudentID(updatedEntry.getStudentID());

            userRepository.save(existingEntry);
            return ResponseEntity.ok("User's profile has been updated successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{studentID}")
    public ResponseEntity<String> deleteUser(@PathVariable("studentID") String studentID) {
        Optional<UserEntity> user = Optional.ofNullable(userRepository.findByStudentID(studentID));
        if (user.isPresent()) {
            userRepository.deleteById(user.get().getUserid());
            return ResponseEntity.ok("User has deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getByUserid")
    public ResponseEntity findByUserid(
            @RequestParam(name = "studentID", required = false, defaultValue = "0") String studentID,
            @RequestParam(name = "password", required = false, defaultValue = "0") String password) {

        UserEntity user = userService.findByStudentID(studentID);

        if (user != null && user.getPassword().equals(password)) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Log-in invalid");
        }
    }

    @PostMapping("/forgotpassword")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        String resetToken = generateResetToken();
        emailService.sendEmail(request.getEmail(), "WellTalk Password Reset Request", "Your reset token: " + resetToken);
        return ResponseEntity.ok("Password reset email sent successfully");
    }

    private String generateResetToken() {
        int tokenLength = 32;
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[tokenLength];
        secureRandom.nextBytes(tokenBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }

    @PutMapping("/updatepassword")
    public ResponseEntity<String> updatePassword(@RequestBody PasswordUpdateRequest request) {
        if (request == null || request.getEmail() == null || request.getNewPassword() == null) {
            return ResponseEntity.badRequest().body("Invalid request");
        }

        UserEntity user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        user.setPassword(request.getNewPassword());
        userRepository.save(user);

        return ResponseEntity.ok("Password updated successfully");
    }
}
