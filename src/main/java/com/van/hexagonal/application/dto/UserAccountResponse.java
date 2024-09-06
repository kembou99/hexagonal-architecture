package com.van.hexagonal.application.dto;

import com.van.hexagonal.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccountResponse {
    private Long id;

    private String username;

    private boolean isEnable;

    private  boolean logged;

    private String language;

    private RoleResponse role;

}
