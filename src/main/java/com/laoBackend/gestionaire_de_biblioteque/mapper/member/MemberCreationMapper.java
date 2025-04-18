package com.laoBackend.gestionaire_de_biblioteque.mapper.member;

import com.laoBackend.gestionaire_de_biblioteque.domain.Member;
import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberCreationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface MemberCreationMapper {
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "id", ignore = true)
    Member toEntity(MemberCreationDTO memberCreationDTO);
}
