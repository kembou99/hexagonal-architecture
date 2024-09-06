package com.van.hexagonal.domain.model;

import java.time.Instant;

public class UserAccountSession {
    private Long id;

    private UserAccount userAccount;

    private Instant startDate;

    private Instant endDate;


    public UserAccountSession(Long id, UserAccount userAccount, Instant startDate, Instant endDate) {
        this.id = id;
        this.userAccount = userAccount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UserAccountSession() {
    }

    public Long getId() {
        return id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public void setId(Long id) {
        if(id==null)
            throw new RuntimeException("id is mandatory");
        this.id = id;
    }

    public void setUserAccount(UserAccount userAccount) {
        if(userAccount==null)
            throw new RuntimeException("userAccount is mandatory");
        this.userAccount = userAccount;
    }

    public void setStartDate(Instant startDate) {
        if(startDate==null)
            throw new RuntimeException("startDate is mandatory");
        this.startDate = startDate;
    }

    public void setEndDate(Instant endDate) {
        this.endDate = endDate;
    }
}
