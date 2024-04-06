package com.example.project.entity.auth;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "user", schema = "public")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final UUID id;

    private String name;

    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    public UserEntity(UUID id, String name, String email, Role role, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public UserEntity() {
        this.id = null;
        this.role = null;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
