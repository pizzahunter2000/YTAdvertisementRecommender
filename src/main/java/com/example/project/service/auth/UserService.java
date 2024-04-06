package com.example.project.service.auth;

import com.example.project.entity.auth.User;
import com.example.project.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(UUID id){
        return userRepository.findById(id).orElse(null);
    }

    public ResponseEntity<User> saveUser(User user){
        User savedUser = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    public void deleteUserById(UUID id){
        userRepository.deleteById(id);
    }
}
