package com.laoBackend.gestionaire_de_biblioteque.domain;

import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Member(Long id, String name, String email, String address, LocalDateTime createdOn, LocalDateTime updatedOn, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.role = role;
    }

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}