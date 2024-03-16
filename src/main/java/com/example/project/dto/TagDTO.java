package com.example.project.dto;

import java.util.UUID;

public class TagDTO {
    private final UUID id;
    private String name;

    public TagDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
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
