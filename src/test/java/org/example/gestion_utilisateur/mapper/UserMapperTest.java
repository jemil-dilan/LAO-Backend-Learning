package org.example.gestion_utilisateur.mapper;

import org.example.gestion_utilisateur.domain.User;
import org.example.gestion_utilisateur.dto.CreateUserDTO;
import org.example.gestion_utilisateur.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    UserMapper objectUnderTest = Mappers.getMapper(UserMapper.class);

    @Test
    void toEntityTest() {

        CreateUserDTO createUserDTO = CreateUserDTO.builder()
                .email("<EMAIL>")
                .firstName("joe")
                .lastName("boss")
                .build();

        User resultUnderTest = objectUnderTest.toEntity(createUserDTO);

        assertThat(resultUnderTest)
                .isNotNull()
                .isInstanceOf(User.class)
                .hasFieldOrPropertyWithValue("email", "<EMAIL>")
                .hasFieldOrPropertyWithValue("firstName", "joe")
                .hasFieldOrPropertyWithValue("lastName", "boss");
    }

    @Test
    void toDTOTest() {
        User user = User.builder()
                .id(1L)
                .email("<EMAIL>")
                .firstName("joe")
                .lastName("boss")
                .build();

        UserDTO resultUnderTest = objectUnderTest.toDTO(user);

        assertThat(resultUnderTest)
                .isNotNull()
                .isInstanceOf(UserDTO.class)
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("email", "<EMAIL>")
                .hasFieldOrPropertyWithValue("firstName", "joe")
                .hasFieldOrPropertyWithValue("lastName", "boss");
    }
}