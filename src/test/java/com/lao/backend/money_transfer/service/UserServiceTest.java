package com.lao.backend.money_transfer.service;

import com.lao.backend.money_transfer.domain.User;
import com.lao.backend.money_transfer.dto.CreateUserDTO;
import com.lao.backend.money_transfer.dto.UserDTO;
import com.lao.backend.money_transfer.mapper.user.CreateUserMapper;
import com.lao.backend.money_transfer.mapper.user.UserMapper;
import com.lao.backend.money_transfer.repository.UserRepository;
import com.lao.backend.money_transfer.testBuilder.user.CreateUserBuilder;
import com.lao.backend.money_transfer.testBuilder.user.UserBuilder;
import com.lao.backend.money_transfer.testBuilder.user.UserDtoBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;
    @Mock
    UserMapper userMapper;
    @Mock
    CreateUserMapper createUserMapper;

    @InjectMocks
    UserService userService;

    UserBuilder userBuilder = new UserBuilder();
    UserDtoBuilder userDtoBuilder = new UserDtoBuilder();
    CreateUserBuilder createUserBuilder = new CreateUserBuilder();


    @Test
    void getAllUserTest() {
        User user= userBuilder.build();
        UserDTO userDTO = userDtoBuilder.build();

        when(userRepository.findAll()).thenReturn(List.of(user));
        when(userMapper.toUserDTO(any(User.class))).thenReturn(userDTO);

        var result = userService.getAllUsers();

        assertEquals(userDTO.getId(), result.getFirst().getId());
        assertEquals(userDTO.getName(), result.getFirst().getName());
        assertEquals(userDTO.getEmail(), result.getFirst().getEmail());
        assertEquals(userDTO.getAddress(), result.getFirst().getAddress());
        assertEquals(userDTO.getAccountNumber(), result.getFirst().getAccountNumber());
        assertEquals(userDTO.getDateOfBirth(), result.getFirst().getDateOfBirth());
        assertEquals(userDTO.getPhoneNumber(), result.getFirst().getPhoneNumber());
        assertThat(List.of(userDTO)).isEqualTo(result);
        assertThat(result).hasSize(1).containsOnly(userDTO);

        verify(userRepository).findAll();
        verify(userMapper).toUserDTO(any(User.class));
    }

    @Test
    void getByIdTest(){
        var user = userBuilder.build();
        var userDTO = userDtoBuilder.build();

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(userMapper.toUserDTO(any(User.class))).thenReturn(userDTO);

        var result = userService.getUserById(2L);

        assertEquals(userDTO.getId(), result.getId());
        assertEquals(userDTO.getName(), result.getName());
        assertEquals(userDTO.getEmail(), result.getEmail());
        assertEquals(userDTO.getAddress(), result.getAddress());
        assertEquals(userDTO.getAccountNumber(), result.getAccountNumber());
        assertEquals(userDTO.getDateOfBirth(), result.getDateOfBirth());
        assertEquals(userDTO.getPhoneNumber(), result.getPhoneNumber());
        assertThat(userDTO).isEqualTo(result);

        verify(userRepository).findById(anyLong());
        verify(userMapper).toUserDTO(any(User.class));
    }

    @Test
    void deleteUser(){
        when(userRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(userRepository).deleteById(anyLong());

        userService.deleteUser(1L);

        verify(userRepository).existsById(anyLong());
        verify(userRepository).deleteById(anyLong());
    }

    @Test
    void creatUserTest(){
        var creatUserDTO = createUserBuilder.build();
        var user = userBuilder.build();
        var userDTO = userDtoBuilder.build();

        when(userRepository.existByEmail(anyString())).thenReturn(false);
        when(createUserMapper.toUser(any(CreateUserDTO.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userMapper.toUserDTO(any(User.class))).thenReturn(userDTO);

        var result = userService.createUser(creatUserDTO);

        assertEquals(userDTO.getId(), result.getId());
        assertEquals(userDTO.getName(), result.getName());
        assertEquals(userDTO.getEmail(), result.getEmail());
        assertEquals(userDTO.getAddress(), result.getAddress());
        assertEquals(userDTO.getAccountNumber(), result.getAccountNumber());
        assertEquals(userDTO.getDateOfBirth(), result.getDateOfBirth());
        assertEquals(userDTO.getPhoneNumber(), result.getPhoneNumber());
        assertThat(userDTO).isEqualTo(result);

        verify(userRepository).existByEmail(anyString());
        verify(createUserMapper).toUser(any(CreateUserDTO.class));
        verify(userRepository).save(any(User.class));
        verify(userMapper).toUserDTO(any(User.class));
    }

    @Test
    void updateUserTest(){
        var creatUserDTO = createUserBuilder.build();
        var user = userBuilder.build();
        var userDTO = userDtoBuilder.build();

        when(userRepository.existsById(anyLong())).thenReturn(true);
        when(createUserMapper.toUser(any(CreateUserDTO.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userRepository.findAll()).thenReturn((List.of(user)));
        when(userMapper.toUserDTO(any(User.class))).thenReturn(userDTO);

        userService.updateUser(1L, creatUserDTO);
        var result = userService.getAllUsers();

        assertEquals(userDTO.getId(), result.getFirst().getId());
        assertEquals(userDTO.getName(), result.getFirst().getName());
        assertEquals(userDTO.getEmail(), result.getFirst().getEmail());
        assertEquals(userDTO.getAddress(), result.getFirst().getAddress());
        assertEquals(userDTO.getAccountNumber(), result.getFirst().getAccountNumber());
        assertEquals(userDTO.getDateOfBirth(), result.getFirst().getDateOfBirth());
        assertEquals(userDTO.getPhoneNumber(), result.getFirst().getPhoneNumber());
        assertThat(List.of(userDTO)).isEqualTo(result);
        assertThat(result).hasSize(1).containsOnly(userDTO);

        verify(userRepository).existsById(anyLong());
        verify(createUserMapper).toUser(any(CreateUserDTO.class));
        verify(userRepository).save(any(User.class));
        verify(userRepository).findAll();
        verify(userMapper).toUserDTO(any(User.class));
    }
}