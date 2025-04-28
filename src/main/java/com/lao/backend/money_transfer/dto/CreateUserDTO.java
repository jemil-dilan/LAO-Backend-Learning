package com.lao.backend.money_transfer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class CreateUserDTO {
    private String name;
    private String email;
    private String address;
    private LocalDate dateOfBirth;
    private String phoneNumber;

    public CreateUserDTO() {
    }

    public CreateUserDTO(String address, String name, String email, LocalDate dateOfBirth, String phoneNumber) {
        this.address = address;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
