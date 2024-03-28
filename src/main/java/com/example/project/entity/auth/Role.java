package com.example.project.entity.auth;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    public Role(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {}

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
