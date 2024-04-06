package com.example.project.controller.auth;

import com.example.project.dto.auth.LoginDTO;
import com.example.project.dto.auth.RegisterDTO;
import com.example.project.entity.auth.Role;
import com.example.project.entity.auth.UserEntity;
import com.example.project.repository.auth.RoleRepository;
import com.example.project.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          UserRepository userRepository, RoleRepository roleRepository,
                          PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Validated @RequestBody RegisterDTO registerDTO, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>("Invalid input!", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByName(registerDTO.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }
        UserEntity user = new UserEntity();
        user.setName(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setEmail(registerDTO.getEmail());

        Role role = roleRepository.findByName("User").get();
        user.setRole(role);

        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Validated @RequestBody LoginDTO loginDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>("Invalid input!", HttpStatus.BAD_REQUEST);
        }
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),
                            loginDTO.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("User signed in successfully!", HttpStatus.OK);
        } catch (Exception e) {
            throw new BadCredentialsException("Incorrect username or password");
        }

    }
}
