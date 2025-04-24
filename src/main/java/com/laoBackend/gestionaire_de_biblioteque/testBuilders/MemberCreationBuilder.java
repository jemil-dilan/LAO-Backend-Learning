package com.laoBackend.gestionaire_de_biblioteque.testBuilders;

import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberCreationDTO;

public class MemberCreationBuilder {
    private String name = "Pollo";
    private String email = "POLO@cil.zo";
    private String address = "bonanjo";
    private String role = "MEMBER";


    public MemberCreationBuilder withName(String name){
        this.name= name;
        return this;
    }
    public MemberCreationBuilder withEmail(String email){
        this.email= email;
        return this;
    }
    public MemberCreationBuilder withAddress(String address){
        this.address= address;
        return this;
    }

    public MemberCreationBuilder withRole(String role){
        this.role= role;
        return this;
    }

    public MemberCreationDTO build(){
        return new MemberCreationDTO(name,email,address,role);
    }
}
