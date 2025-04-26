package com.lao.backend.money_transfer.testBuilder.user;

import com.lao.backend.money_transfer.domain.Account;
import com.lao.backend.money_transfer.domain.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserBuilder {
    private Long id = 2L;
    private String name = "Boston";
    private String email = "boston@example.com";
    private String address = "Bonaberi";
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private Account userAccount = null;
    private LocalDateTime creationDate;
    private LocalDateTime updatedDate;


    public UserBuilder withId(Long id){
        this.id = id;
        return this;
    }
    public UserBuilder withName(String name){
        this.name = name;
        return this;
    }
    public UserBuilder withEmail(String email){
        this.email = email;
        return this;
    }
    public  UserBuilder withDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        return this;
    }
    public UserBuilder withPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }
    public UserBuilder withAccount(Account userAccount){
        this.userAccount = userAccount;
        return this;
    }
    public UserBuilder withCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
        return this;
    }
    public UserBuilder withUpdatedDate(LocalDateTime updatedDate){
        this.updatedDate = updatedDate;
        return this;
    }

    public User build(){
        return new User(id,name,email,address,dateOfBirth,phoneNumber,userAccount,creationDate,updatedDate);
    }
}
