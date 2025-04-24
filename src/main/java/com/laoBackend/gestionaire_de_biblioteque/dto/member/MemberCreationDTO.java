package com.laoBackend.gestionaire_de_biblioteque.dto.member;


public class MemberCreationDTO {
    private String name;
    private String email;
    private String address;
    private String role;

    public MemberCreationDTO(String name, String email, String address, String role) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    public MemberCreationDTO() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}