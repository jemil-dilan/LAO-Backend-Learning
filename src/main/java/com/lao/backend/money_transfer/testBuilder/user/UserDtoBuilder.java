package com.lao.backend.money_transfer.testBuilder.user;

import com.lao.backend.money_transfer.dto.UserDTO;

import java.time.LocalDate;


public class UserDtoBuilder {
    private Long id = 2L;
    private String name = "Boston";
    private String email = "boston@example.com";
    private String address = "Bonaberi";
    private String accountNumber = "csc7c4vsdv4sdv8";
    private LocalDate dateOfBirth = LocalDate.of(2002,2,18);
    private String phoneNumber = "+237 651 12 54 32";

    public UserDtoBuilder withId(Long id){
        this.id = id;
        return this;
    }
    public UserDtoBuilder withName(String name){
        this.name = name;
        return this;
    }
    public UserDtoBuilder withEmail(String email){
        this.email = email;
        return this;
    }
    public UserDtoBuilder withAddress(String address){
        this.address = address;
        return this;
    }
    public UserDtoBuilder withDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        return this;
    }
    public UserDtoBuilder withPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }
    public UserDtoBuilder withAccount(String userAccount){
        this.accountNumber = userAccount;
        return this;
    }
    public UserDTO build(){
        return new UserDTO(id,name,email,address,dateOfBirth,phoneNumber,accountNumber);
    }

}
