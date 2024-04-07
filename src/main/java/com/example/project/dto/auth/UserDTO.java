package com.example.project.dto.auth;

import com.example.project.validation.ValidPassword;
import com.example.project.validation.ValidUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class UserDTO {
    private UUID id;

    @NotBlank
    @ValidUsername
    private String name;

    @NotBlank
    @Email
    private String email;
    @ValidPassword
    private String password;
    private UUID role;

    public UserDTO(UUID id, String name, String email, UUID role, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getRole() {
        return role;
    }

    public void setRole(UUID role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
