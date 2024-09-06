package com.van.hexagonal.domain.exceptions;

public class UserAccountAlreadyExistException extends RuntimeException{
    public UserAccountAlreadyExistException() {
        super("This user is already exist");
    }
}
