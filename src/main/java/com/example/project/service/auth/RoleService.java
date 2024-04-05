package com.example.project.service.auth;

import com.example.project.entity.auth.Role;
import com.example.project.repository.auth.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getRoleById(UUID id){
        return roleRepository.findById(id).orElse(null);
    }

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    public void deleteRoleById(UUID id){
        roleRepository.deleteById(id);
    }
}
