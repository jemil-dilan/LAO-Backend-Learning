package com.laoBackend.gestionaire_de_biblioteque.service;

import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Role;
import com.laoBackend.gestionaire_de_biblioteque.domain.Member;
import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberCreationDTO;
import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberDTO;
import com.laoBackend.gestionaire_de_biblioteque.mapper.member.MemberCreationMapper;
import com.laoBackend.gestionaire_de_biblioteque.mapper.member.MemberMapper;
import com.laoBackend.gestionaire_de_biblioteque.repository.MemberRepository;
import com.laoBackend.gestionaire_de_biblioteque.testBuilders.MemberBuilder;
import com.laoBackend.gestionaire_de_biblioteque.testBuilders.MemberCreationBuilder;
import com.laoBackend.gestionaire_de_biblioteque.testBuilders.MemberDTOBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

    MemberBuilder memberBuilder = new MemberBuilder();
    MemberDTOBuilder memberDTOBuilder = new MemberDTOBuilder();
    MemberCreationBuilder memberCreationBuilder = new MemberCreationBuilder();

    @Test
    void createMember() {
        MemberCreationDTO memberCreationDTO = memberCreationBuilder.build();

        Member member = memberBuilder.build();

        MemberDTO memberDTO = memberDTOBuilder.build();

        when(memberCreationMapper.toEntity(memberCreationDTO)).thenReturn(member);
        when(memberRepository.save(any(Member.class))).thenReturn(member);
        when(memberMapper.toDto(any(Member.class))).thenReturn(memberDTO);

        MemberDTO result = memberService.createMember(memberCreationDTO);

        assertThat(result).isEqualTo(memberDTO);
        assertEquals(memberDTO.getId(), result.getId());
        assertEquals(memberDTO.getName(), result.getName());
        assertEquals(memberDTO.getAddress(), result.getAddress());
        assertEquals(memberDTO.getEmail(), result.getEmail());
        assertEquals(memberDTO.getRole(), result.getRole());

        verify(memberRepository).save(any(Member.class));
        verify(memberCreationMapper).toEntity(memberCreationDTO);
        verify(memberMapper).toDto(any(Member.class));

    }

    @Test
    void getAllMembers() {
        Member member1 = memberBuilder.build();
        Member member2 = memberBuilder.withName("Roy").withAddress("ndokoti")
                .withRole(Role.LIBRARIAN).withEmail("roy@email.com").withId(2L).build();

        MemberDTO memberDTO1 =  memberDTOBuilder.build();
        MemberDTO memberDTO2 = memberDTOBuilder.withName("Roy").withAddress("ndokoti")
                .withRole("LIBRARIAN").withEmail("roy@email.com").withId(2L).build();


        when(memberRepository.findAll()).thenReturn(List.of(member1,member2));
        when(memberMapper.toDto(List.of(member1, member2))).thenReturn(List.of(memberDTO1, memberDTO2));


        List<MemberDTO> result = memberService.getAllMembers();

        assertThat(result).hasSize(2).contains(memberDTO1, memberDTO2);
        assertEquals(memberDTO1.getId(), result.getFirst().getId());
        assertEquals(memberDTO1.getName(), result.getFirst().getName());
        assertEquals(memberDTO1.getAddress(), result.getFirst().getAddress());
        assertEquals(memberDTO1.getEmail(), result.getFirst().getEmail());
        assertEquals(memberDTO1.getRole(), result.getFirst().getRole());

        assertEquals(memberDTO2.getId(), result.getLast().getId());
        assertEquals(memberDTO2.getName(), result.getLast().getName());
        assertEquals(memberDTO2.getAddress(), result.getLast().getAddress());
        assertEquals(memberDTO2.getEmail(), result.getLast().getEmail());
        assertEquals(memberDTO2.getRole(), result.getLast().getRole());


        verify(memberMapper).toDto(List.of(member1, member2));
        verify(memberRepository).findAll();
    }

    @Test
    void getMemberById() {
        Member member = memberBuilder.build();
       MemberDTO memberDTO = memberDTOBuilder.build();

        when(memberRepository.findById(anyLong())).thenReturn(Optional.of(member));
        when(memberMapper.toDto(any(Member.class))).thenReturn(memberDTO);

        MemberDTO result = memberService.getMemberById(2L);

        assertEquals(memberDTO.getId(), result.getId());
        assertEquals(memberDTO.getName(), result.getName());
        assertEquals(memberDTO.getAddress(), result.getAddress());
        assertEquals(memberDTO.getEmail(), result.getEmail());
        assertEquals(memberDTO.getRole(), result.getRole());
        assertThat(result).isEqualTo(memberDTO);

        verify(memberRepository).findById(2L);
        verify(memberMapper).toDto(any(Member.class));

    }

    @Test
    void updateMember() {
        MemberCreationDTO memberCreationDTO = memberCreationBuilder.withName("Roy").withAddress("ndokoti")
                .withRole("LIBRARIAN").withEmail("roy@email.com").build();

        Member member = memberBuilder.withName("Roy").withAddress("ndokoti")
                .withRole(Role.LIBRARIAN).withEmail("roy@email.com").withId(2L).build();

        MemberDTO memberDTO = memberDTOBuilder.withName("Roy").withAddress("ndokoti")
                .withRole("LIBRARIAN").withEmail("roy@email.com").withId(2L).build();

        when(memberRepository.existsById(anyLong())).thenReturn(true);
        when(memberCreationMapper.toEntity(memberCreationDTO)).thenReturn(member);
        when(memberRepository.save(any(Member.class))).thenReturn(member);
        when(memberRepository.findAll()).thenReturn(List.of(member));
        when(memberMapper.toDto(List.of(member))).thenReturn(List.of(memberDTO));

        memberService.updateMember(1L,memberCreationDTO);
        List<MemberDTO> result = memberService.getAllMembers();

        assertEquals(memberDTO.getId(), result.getFirst().getId());
        assertEquals(memberDTO.getName(), result.getFirst().getName());
        assertEquals(memberDTO.getAddress(), result.getFirst().getAddress());
        assertEquals(memberDTO.getEmail(), result.getFirst().getEmail());
        assertEquals(memberDTO.getRole(), result.getFirst().getRole());
        assertThat(result).hasSize(1).contains(memberDTO);

        verify(memberRepository).existsById(anyLong());
        verify(memberCreationMapper).toEntity(memberCreationDTO);
        verify(memberRepository).save(any(Member.class));
        verify(memberMapper).toDto(List.of(member));


    }

    @Test
    void deleteMember() {
        doNothing().when(memberRepository).deleteById(anyLong());
        memberService.deleteMember(1L);

        verify(memberRepository).deleteById(anyLong());
    }
}