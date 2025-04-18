package com.laoBackend.gestionaire_de_biblioteque.controller;

import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberCreationDTO;
import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberDTO;
import com.laoBackend.gestionaire_de_biblioteque.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers(){
        List<MemberDTO> allMembers = memberService.getAllMembers();
        return allMembers.isEmpty() ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.ok(allMembers);
    }

    @PostMapping
    public ResponseEntity<MemberDTO> createMember(@RequestBody MemberCreationDTO memberCreationDTO){
        MemberDTO createdMember = memberService.createMember(memberCreationDTO);
        return createdMember == null ?
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build() :
                ResponseEntity.status(HttpStatus.CREATED).body(createdMember);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable Long id){
        MemberDTO member = memberService.getMemberById(id);
        return member == null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.ok(member);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> updateMember(@PathVariable Long id, @RequestBody MemberCreationDTO memberCreationDTO){
        MemberDTO updatedMember = memberService.updateMember(id, memberCreationDTO);
        return updatedMember == null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
