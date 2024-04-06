package com.example.project.security;

public class SecurityConstants {
    public static final long JWT_EXPIRATION = 70000;
    public static final String JWT_SECRET = "secret santa is here, this key has to be at least" +
            "256 bytes long, that is probably 256 characters";
}
