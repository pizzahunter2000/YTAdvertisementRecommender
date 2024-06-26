package com.example.project.converter.auth;

import com.example.project.dto.auth.RoleDTO;
import com.example.project.converter.Converter;
import com.example.project.entity.auth.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<RoleDTO, Role> {
    @Override
    public Role convertToEntity(RoleDTO dto) {
        return new Role(dto.getId(), dto.getName());
    }
}
