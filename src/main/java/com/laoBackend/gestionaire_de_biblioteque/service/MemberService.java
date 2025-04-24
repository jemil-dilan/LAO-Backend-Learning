package com.laoBackend.gestionaire_de_biblioteque.service;

import com.laoBackend.gestionaire_de_biblioteque.domain.Member;
import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberCreationDTO;
import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberDTO;
import com.laoBackend.gestionaire_de_biblioteque.mapper.member.MemberCreationMapper;
import com.laoBackend.gestionaire_de_biblioteque.mapper.member.MemberMapper;
import com.laoBackend.gestionaire_de_biblioteque.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final MemberCreationMapper memberCreationMapper;
    private final MemberMapper memberMapper;

    public MemberService(MemberRepository memberRepository, MemberCreationMapper memberCreationMapper, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberCreationMapper = memberCreationMapper;
        this.memberMapper = memberMapper;
    }

    public MemberDTO createMember(MemberCreationDTO memberCreationDTO){
        if(memberRepository.existsByEmail(memberCreationDTO.getEmail())) {
            throw new IllegalArgumentException("Member already exist");
        }
        Member member = memberCreationMapper.toEntity(memberCreationDTO);
        member.setCreatedOn(LocalDateTime.now());
        memberRepository.save(member);
        return memberMapper.toDto(member);
    }

    public List<MemberDTO> getAllMembers() {
        return memberMapper.toDto(memberRepository.findAll());
    }
    public MemberDTO getMemberById(Long id) {
        return memberRepository.findById(id)
                .map(memberMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("member not found"));
    }
    public void updateMember(Long id, MemberCreationDTO memberCreationDTO) {
        if (memberRepository.existsById(id)) {
            Member member = memberCreationMapper.toEntity(memberCreationDTO);
            member.setId(id);
            memberRepository.save(member);
        } else {
            throw new ResourceNotFoundException("Member not found");
        }

    }
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
