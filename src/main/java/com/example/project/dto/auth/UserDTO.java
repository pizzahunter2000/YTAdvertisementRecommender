package com.example.project.dto.auth;

import java.util.UUID;

public class UserDTO {
    private UUID id;
    private String name;
    private String email;
    private UUID role;

    public UserDTO(UUID id, String name, String email, UUID role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
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
}
