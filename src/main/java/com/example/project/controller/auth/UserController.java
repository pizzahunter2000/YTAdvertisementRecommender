package com.example.project.controller.auth;

import com.example.project.dto.auth.UserDTO;
import com.example.project.dto_entity_converter.auth.UserConverter;
import com.example.project.entity.auth.User;
import com.example.project.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/auth/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @GetMapping
    private List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    private User getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @PostMapping
    private User saveUser(@RequestBody UserDTO userDTO) {
        User user = userConverter.convertToEntity(userDTO);
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    private User updateUser(@PathVariable UUID id, @RequestBody UserDTO userDTO){
        User existingUser = userService.getUserById(id);
        User updatedUser = userConverter.convertToEntity(userDTO);
        if(existingUser != null){
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setRole(updatedUser.getRole());
            return userService.saveUser(existingUser);
        } else {
            return userService.saveUser(updatedUser);
        }
    }

    @DeleteMapping("/{id}")
    private void deleteUserById(@PathVariable UUID id){
        userService.deleteUserById(id);
    }
}
