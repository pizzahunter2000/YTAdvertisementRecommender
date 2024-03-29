package com.example.project.dto.auth;

import java.util.UUID;

public class RoleDTO {
    private UUID id;
    private String name;

    public RoleDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleDTO(String name) {
        this.name = name;
        id = null;
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
}
