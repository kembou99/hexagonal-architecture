package com.van.hexagonal.domain.exceptions;

public class UserAccountNotFoundException extends RuntimeException{
    public UserAccountNotFoundException() {
        super("user not found");
    }
}
