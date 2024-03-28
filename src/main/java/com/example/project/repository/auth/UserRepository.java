package com.example.project.repository.auth;

import com.example.project.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> { }
