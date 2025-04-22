package com.laoBackend.gestionaire_de_biblioteque.service;

import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Role;
import com.laoBackend.gestionaire_de_biblioteque.domain.Member;
import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberCreationDTO;
import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberDTO;
import com.laoBackend.gestionaire_de_biblioteque.mapper.member.MemberCreationMapper;
import com.laoBackend.gestionaire_de_biblioteque.mapper.member.MemberMapper;
import com.laoBackend.gestionaire_de_biblioteque.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
    @Mock
    MemberRepository memberRepository;
    @Mock
    MemberCreationMapper memberCreationMapper;
    @Mock
    MemberMapper memberMapper;

    @InjectMocks
    MemberService memberService;

    @Test
    void createMember() {
        MemberCreationDTO memberCreationDTO = new MemberCreationDTO(
                "john",
                "john@email.com",
                "logbesou",
                "MEMBER"
        );

        Member member = new Member(
                1L,
                "john",
                "john@email.com",
                "logbesou",
                LocalDateTime.now(),
                null,
                Role.MEMBER
        );

        MemberDTO memberDTO = new MemberDTO(
                1L,
                "john",
                "john@email.com",
                "logbesou",
                "MEMBER"
        );

        when(memberCreationMapper.toEntity(memberCreationDTO)).thenReturn(member);
        when(memberRepository.save(member)).thenReturn(member);
        when(memberMapper.toDto(member)).thenReturn(memberDTO);

        MemberDTO result = memberService.createMember(memberCreationDTO);

        assertThat(result).isEqualTo(memberDTO);

        verify(memberRepository).save(member);
        verify(memberCreationMapper).toEntity(memberCreationDTO);
        verify(memberMapper).toDto(member);

    }

    @Test
    void getAllMembers() {
        MemberDTO memberDTO1 =  new MemberDTO(
                        1L,
                        "john",
                        "john@email.com",
                        "logbesou",
                        "MEMBER"
                );
        MemberDTO memberDTO2 = new MemberDTO(
                        2L,
                        "Roy",
                        "roy@email.com",
                        "ndokoti",
                        "LIBRARIAN"
                );

        Member member1 = new Member(
                        1L,
                        "john",
                        "john@email.com",
                        "logbesou",
                        LocalDateTime.now(),
                        null,
                        Role.MEMBER
                );
        Member member2 = new Member(
                        2L,
                        "Roy",
                        "roy@email.com",
                        "ndokoti",
                        LocalDateTime.now().minusDays(5),
                        null,
                        Role.LIBRARIAN
                );

        when(memberRepository.findAll()).thenReturn(List.of(member1,member2));
        when(memberMapper.toDto(List.of(member1,member2)))
                .thenReturn(List.of(memberDTO1, memberDTO2));

        List<MemberDTO> result = memberService.getAllMembers();
        assertThat(result).isEqualTo(List.of(memberDTO1, memberDTO2));
        assertEquals(result.size(), List.of(memberDTO1, memberDTO2).size());

        verify(memberMapper).toDto(List.of(member1,member2));
        verify(memberRepository).findAll();
    }

    @Test
    void getMemberById() {
        Optional<Member> member = Optional.of(new Member(2L,
                "Roy",
                "roy@email.com",
                "ndokoti",
                LocalDateTime.now().minusDays(5),
                null,
                Role.LIBRARIAN));
        Optional<MemberDTO> memberDTO = Optional.of(new MemberDTO(
                2L,
                "Roy",
                "roy@email.com",
                "ndokoti",
                "LIBRARIAN"));

        when(memberRepository.findById(2L)).thenReturn(member);
        when(memberMapper.toDto(member.get())).thenReturn(memberDTO.get());

        MemberDTO result = memberService.getMemberById(2L);

        assertThat(result).isEqualTo(memberDTO.get());

        verify(memberRepository).findById(2L);
        verify(memberMapper).toDto(member.get());

    }

    @Test
    void updateMember() {
        MemberCreationDTO memberCreationDTO = new MemberCreationDTO(
                "john charle",
                "john@email.com",
                "logbaba",
                "MEMBER"
        );

        Member member = new Member(
                1L,
                "john charle",
                "john@email.com",
                "logbaba",
                LocalDateTime.now().minusDays(9),
                LocalDateTime.now(),
                Role.MEMBER
        );

        MemberDTO memberDTO = new MemberDTO(
                1L,
                "john charle",
                "john@email.com",
                "logbaba",
                "MEMBER"
        );

        when(memberRepository.existsById(1L)).thenReturn(true);
        when(memberCreationMapper.toEntity(memberCreationDTO)).thenReturn(member);
        when(memberRepository.save(member)).thenReturn(member);
        when(memberMapper.toDto(member)).thenReturn(memberDTO);

        MemberDTO result = memberService.updateMember(1L,memberCreationDTO);

        assertEquals(result.getName(), memberDTO.getName());
        assertEquals(result.getAddress(), memberDTO.getAddress());
        assertEquals(result.getEmail(), memberDTO.getEmail());

        verify(memberRepository).existsById(1L);
        verify(memberCreationMapper).toEntity(memberCreationDTO);
        verify(memberRepository).save(member);
        verify(memberMapper).toDto(member);


    }

    @Test
    void deleteMember() {
        long id = 1L;

        doNothing().when(memberRepository).deleteById(isA(Long.class));
        memberService.deleteMember(id);

        verify(memberRepository).deleteById(id);
    }
}