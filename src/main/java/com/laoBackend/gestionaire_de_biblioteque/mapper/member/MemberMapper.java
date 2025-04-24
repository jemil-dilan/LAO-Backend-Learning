package com.laoBackend.gestionaire_de_biblioteque.mapper.member;

import com.laoBackend.gestionaire_de_biblioteque.domain.Member;
import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberDTO toDto(Member member);

    List<MemberDTO> toDto(List<Member> members);
}
