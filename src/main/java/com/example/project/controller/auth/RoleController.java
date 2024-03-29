package com.example.project.controller.auth;

import com.example.project.dto.auth.RoleDTO;
import com.example.project.dto_entity_converter.auth.RoleConverter;
import com.example.project.entity.auth.Role;
import com.example.project.service.auth.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/auth/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleConverter roleConverter;

    @GetMapping
    private List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    private Role getRoleById(@PathVariable UUID id){
        return roleService.getRoleById(id);
    }

    @PostMapping
    private Role saveRole(@RequestBody RoleDTO roleDTO){
        Role role = roleConverter.convertToEntity(roleDTO);
        return roleService.saveRole(role);
    }

    @PutMapping("/{id}")
    private Role updateRole(@PathVariable UUID id, @RequestBody RoleDTO roleDTO){
        Role existingRole = roleService.getRoleById(id);
        Role newRole = roleConverter.convertToEntity(roleDTO);
        if(existingRole != null){
            existingRole.setName(newRole.getName());
            return roleService.saveRole(existingRole);
        } else {
            return roleService.saveRole(newRole);
        }
    }

    @DeleteMapping("/{id}")
    private void deleteRoleById(@PathVariable UUID id){
        roleService.deleteRoleById(id);
    }
}
