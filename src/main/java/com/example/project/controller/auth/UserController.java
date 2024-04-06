package com.example.project.controller.auth;

import com.example.project.dto.auth.UserDTO;
import com.example.project.dto_entity_converter.auth.UserConverter;
import com.example.project.entity.auth.User;
import com.example.project.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
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
    private ResponseEntity<?> saveUser(@Validated @RequestBody UserDTO userDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        } else {
            User user = userConverter.convertToEntity(userDTO);
            if(user == null){
                return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
            }
            ResponseEntity<User> responseEntity = userService.saveUser(user);
            return new ResponseEntity<>(responseEntity.getBody(), responseEntity.getStatusCode());

        }
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateUser(@PathVariable UUID id, @Validated @RequestBody UserDTO userDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        } else{
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

    }

    @DeleteMapping("/{id}")
    private void deleteUserById(@PathVariable UUID id){
        userService.deleteUserById(id);
    }
}
