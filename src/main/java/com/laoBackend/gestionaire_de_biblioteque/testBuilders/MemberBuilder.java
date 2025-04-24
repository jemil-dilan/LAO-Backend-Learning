package com.laoBackend.gestionaire_de_biblioteque.testBuilders;

import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Role;
import com.laoBackend.gestionaire_de_biblioteque.domain.Member;

import java.time.LocalDateTime;

public class MemberBuilder {
    private Long id = 1L;
    private String name = "Pollo";
    private String email = "POLO@cil.zo";
    private String address = "bonanjo";
    private LocalDateTime createdOn = LocalDateTime.of(2024,12,5,12,30);
    private LocalDateTime updatedOn = null;
    private Role role = Role.MEMBER;

    public MemberBuilder withId(Long id){
        this.id= id;
        return this;
    }
    public MemberBuilder withName(String name){
        this.name= name;
        return this;
    }
    public MemberBuilder withEmail(String email){
        this.email= email;
        return this;
    }
    public MemberBuilder withAddress(String address){
        this.address= address;
        return this;
    }
    public MemberBuilder withCreatedOn(LocalDateTime createdOn){
        this.createdOn= createdOn;
        return this;
    }
    public MemberBuilder withUpdatedOn(LocalDateTime UpdatedOn){
        this.updatedOn= UpdatedOn;
        return this;
    }
    public MemberBuilder withRole(Role role){
        this.role= role;
        return this;
    }

    public Member build(){
        return new Member(id,name,email,address,createdOn,updatedOn,role);
    }
}
