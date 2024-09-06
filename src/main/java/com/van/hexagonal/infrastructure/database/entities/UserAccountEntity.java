package com.van.hexagonal.infrastructure.database.entities;

import com.van.hexagonal.domain.model.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_account")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean isEnable;

    @Column(nullable = false,columnDefinition = "BOOLEAN DEFAULT FALSE")
    private  boolean logged;

    @Column(nullable = false)
    private String language;

    @ManyToOne
    @JoinColumn(nullable = false)
    private RoleEntity role;


}
