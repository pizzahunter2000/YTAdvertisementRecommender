package com.example.project.validation;


import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.constraints.Email;

public class EmailValidator implements ConstraintValidator<Email, String>{
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context){
        if(email == null || email.isEmpty()){
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }
}
