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
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @PostMapping
    public ResponseEntity<MemberDTO> createMember(@RequestBody MemberCreationDTO memberCreationDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.createMember(memberCreationDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable Long id){
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMember(@PathVariable Long id, @RequestBody MemberCreationDTO memberCreationDTO){
        memberService.updateMember(id, memberCreationDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
