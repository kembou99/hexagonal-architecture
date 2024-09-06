package com.van.hexagonal.domain.exceptions;

public class RoleNotFoundException extends RuntimeException{

    private Long id;
    public RoleNotFoundException(Long id) {
        super("role not found with id "+id);
    }
}
