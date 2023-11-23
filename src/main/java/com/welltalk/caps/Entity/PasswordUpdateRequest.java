package com.welltalk.caps.Entity;

public class PasswordUpdateRequest {
    private String email;        // The user's email address
    private String newPassword;   // The new password

    // Constructors, getters, and setters

    public PasswordUpdateRequest() {
        // Default constructor
    }

    public PasswordUpdateRequest(String email, String newPassword) {
        this.email = email;
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
