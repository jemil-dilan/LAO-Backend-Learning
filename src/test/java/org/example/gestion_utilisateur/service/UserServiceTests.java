package org.example.gestion_utilisateur.service;

import org.example.gestion_utilisateur.domain.User;
import org.example.gestion_utilisateur.dto.UserDTO;
import org.example.gestion_utilisateur.dto.CreateUserDTO;
import org.example.gestion_utilisateur.mapper.UserMapper;
import org.example.gestion_utilisateur.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    UserRepository userRepository;
    @Mock
    UserMapper userMapper;

    @InjectMocks
    UserService objectUnderTest;

    @Test
    void getAllUsers(){
        //Given
        User user1 = mock();
        User user2 = mock();
        User user3 = mock();
        UserDTO userDTO1 = mock();
        UserDTO userDTO2 = mock();
        UserDTO userDTO3 = mock();

        //When
        when(userMapper.toDTO(user1)).thenReturn(userDTO1);
        when(userMapper.toDTO(user2)).thenReturn(userDTO2);
        when(userMapper.toDTO(user3)).thenReturn(userDTO3);
        when(userRepository.findAll()).thenReturn(List.of(user1, user2, user3));

        //Then
        List<UserDTO> resultUnderTest = objectUnderTest.getAllUsers();

        assertThat(resultUnderTest)
                .hasSize(3)
                .contains(userDTO1, userDTO2, userDTO3)
                .startsWith(userDTO1)
                .endsWith(userDTO3);
    }

    @Test
    void getUserByIdTest() {
        //Given
        User user = mock();
        UserDTO userDTO = mock();

        //When
        when(userMapper.toDTO(user)).thenReturn(userDTO);
        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));

        //Then
        UserDTO resultUnderTest = objectUnderTest.getUserById(2L);

        assertThat(resultUnderTest)
                .usingRecursiveComparison()
                .isEqualTo(userDTO);
    }

    @Test
    void deleteUserTest() {
        //Given

        //When
        when(userRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(userRepository).deleteById(anyLong());

        //Then
        objectUnderTest.deleteUser(2L);

       verify(userRepository).deleteById(anyLong());
       verify(userRepository).existsById(anyLong());
    }
    @Test
    void createUserTest() {
        //Given
        User user = mock();
        UserDTO userDTO = mock();
        CreateUserDTO createUserDTO = mock();

        //When
        when(userRepository.existsByEmail(createUserDTO.getEmail())).thenReturn(false);
        when(userMapper.toEntity(createUserDTO)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userMapper.toDTO(user)).thenReturn(userDTO);


        //Then
        UserDTO resultUnderTest = objectUnderTest.createUser(createUserDTO);

        assertThat(resultUnderTest)
                .usingRecursiveComparison()
                .isEqualTo(userDTO);
    }

    @Test
    void updateUserTest() {
        //Given
        User user = mock();
        User user2 = mock();
        User user3 = mock();
        CreateUserDTO createUserDTO = mock();
        UserDTO userDTO = mock();
        UserDTO userDTO2 = mock();
        UserDTO userDTO3 = mock();

        //When
        when(userRepository.existsById(anyLong())).thenReturn(true);
        when(userMapper.toEntity(createUserDTO)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(userRepository.findAll()).thenReturn(List.of(user, user2, user3));
        when(userMapper.toDTO(user)).thenReturn(userDTO);
        when(userMapper.toDTO(user2)).thenReturn(userDTO2);
        when(userMapper.toDTO(user3)).thenReturn(userDTO3);

        //Then
       objectUnderTest.updateUser(2L,createUserDTO);
        List<UserDTO> resultUnderTest = objectUnderTest.getAllUsers();

        assertThat(resultUnderTest)
                .hasSize(3)
                .contains(userDTO, userDTO2, userDTO3)
                .startsWith(userDTO)
                .endsWith(userDTO3);
        assertThat(resultUnderTest.get(0)).usingRecursiveComparison().isEqualTo(userDTO);

        verify(userRepository).save(user);
        verify(userRepository).existsById(anyLong());
    }
}
