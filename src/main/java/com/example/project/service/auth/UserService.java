package com.example.project.service.auth;

import com.example.project.entity.auth.User;
import com.example.project.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(UUID id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(UUID id){
        userRepository.deleteById(id);
    }
}
