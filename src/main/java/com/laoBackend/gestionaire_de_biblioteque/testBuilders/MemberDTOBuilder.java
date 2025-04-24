package com.laoBackend.gestionaire_de_biblioteque.testBuilders;

import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberDTO;

public class MemberDTOBuilder {
    private Long id = 1L;
    private String name = "Pollo";
    private String email = "POLO@cil.zo";
    private String address = "bonanjo";
    private String role = "MEMBER";

    public MemberDTOBuilder withId(Long id){
        this.id= id;
        return this;
    }
    public MemberDTOBuilder withName(String name){
        this.name= name;
        return this;
    }
    public MemberDTOBuilder withEmail(String email){
        this.email= email;
        return this;
    }
    public MemberDTOBuilder withAddress(String address){
        this.address= address;
        return this;
    }

    public MemberDTOBuilder withRole(String role){
        this.role= role;
        return this;
    }

    public MemberDTO build(){
        return new MemberDTO(id,name,email,address,role);
    }
}
