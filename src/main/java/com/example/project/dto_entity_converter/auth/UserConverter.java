package com.example.project.dto_entity_converter.auth;

import com.example.project.dto.auth.UserDTO;
import com.example.project.dto_entity_converter.Converter;
import com.example.project.entity.auth.Role;
import com.example.project.entity.auth.UserEntity;
import com.example.project.service.auth.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<UserDTO, UserEntity> {
    @Autowired
    private RoleService roleService;

    @Override
    public UserEntity convertToEntity(UserDTO dto) {
        if(dto.getRole() == null){
            return null;
        }
        Role role = roleService.getRoleById(dto.getRole());
        return new UserEntity(dto.getId(), dto.getName(), dto.getEmail(), role, dto.getPassword());
    }
}
