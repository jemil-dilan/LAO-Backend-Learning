package com.laoBackend.gestionaire_de_biblioteque.domain;

import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Role;
import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(getId(), member.getId()) && Objects.equals(getName(), member.getName()) && Objects.equals(getEmail(), member.getEmail()) && Objects.equals(getAddress(), member.getAddress()) && Objects.equals(getCreatedOn(), member.getCreatedOn()) && Objects.equals(getUpdatedOn(), member.getUpdatedOn()) && getRole() == member.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getAddress(), getCreatedOn(), getUpdatedOn(), getRole());
    }
}
