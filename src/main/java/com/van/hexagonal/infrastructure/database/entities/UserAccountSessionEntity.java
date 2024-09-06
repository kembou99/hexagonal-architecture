package com.van.hexagonal.infrastructure.database.entities;

import com.van.hexagonal.domain.model.UserAccount;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "user_account_session")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountSessionEntity {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UserAccountEntity userAccount;

    @Column(nullable = false)
    private Instant startDate;


    private Instant endDate;


}
