package com.lao.backend.money_transfer.testBuilder.user;

import com.lao.backend.money_transfer.dto.CreateUserDTO;

import java.time.LocalDate;

public class CreateUserBuilder {
    private String name = "Boston";
    private String email = "boston@example.com";
    private String address = "Bonaberi";
    private LocalDate dateOfBirth = LocalDate.of(2002,2,18);
    private String phoneNumber = "+237 651 12 54 32";


    public CreateUserBuilder withName(String name){
        this.name = name;
        return this;
    }
    public CreateUserBuilder withEmail(String email){
        this.email = email;
        return this;
    }
    public CreateUserBuilder withAddress(String address){
        this.address = address;
        return this;
    }
    public CreateUserBuilder withDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        return this;
    }
    public CreateUserBuilder withPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }
    public CreateUserDTO build(){
        return new CreateUserDTO(name, email, address,dateOfBirth,phoneNumber);
    }
}
