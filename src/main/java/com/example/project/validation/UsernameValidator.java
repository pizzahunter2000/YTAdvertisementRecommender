package com.example.project.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {
    private static final Pattern USERNAME_PATTERN = Pattern.compile("[\\w\\s.-]+");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null && USERNAME_PATTERN.matcher(s).matches();
    }
}
