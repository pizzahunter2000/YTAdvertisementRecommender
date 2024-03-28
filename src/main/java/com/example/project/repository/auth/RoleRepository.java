package com.example.project.repository.auth;

import com.example.project.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> { }
