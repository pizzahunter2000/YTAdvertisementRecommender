package com.example.project.dto.auth;

import com.example.project.validation.ValidPassword;
import com.example.project.validation.ValidUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterDTO {
    @NotBlank
    @ValidUsername
    private String username;
    @NotBlank
    @ValidPassword
    private String password;
    @NotBlank
    @Email
    private String email;
}
