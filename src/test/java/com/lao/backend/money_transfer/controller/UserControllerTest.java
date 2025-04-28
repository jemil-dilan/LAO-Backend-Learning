package com.lao.backend.money_transfer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lao.backend.money_transfer.dto.CreateUserDTO;
import com.lao.backend.money_transfer.dto.UserDTO;
import com.lao.backend.money_transfer.service.UserService;
import com.lao.backend.money_transfer.testBuilder.user.CreateUserBuilder;
import com.lao.backend.money_transfer.testBuilder.user.UserDtoBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    UserService userService;


    UserDtoBuilder userDtoBuilder = new UserDtoBuilder();
    CreateUserBuilder creationBuilder = new CreateUserBuilder();

    @Test
    public void getAllUsersTest() throws Exception {
        List<UserDTO> userDtoList = List.of(userDtoBuilder.build(), userDtoBuilder.build());

        when(userService.getAllUsers()).thenReturn(userDtoList);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(userDtoList.getFirst().getId()))
                .andExpect(jsonPath("$[0].name").value(userDtoList.getFirst().getName()))
                .andExpect(jsonPath("$[0].email").value(userDtoList.getFirst().getEmail()))
                .andExpect(jsonPath("$[0].address").value(userDtoList.getFirst().getAddress()))
                .andExpect(jsonPath("$[0].phoneNumber").value(userDtoList.getFirst().getPhoneNumber()))
                .andExpect(jsonPath("$[0].accountNumber").value(userDtoList.getFirst().getAccountNumber()))
                .andExpect(jsonPath("$[0].dateOfBirth", Matchers.startsWith(userDtoList.getFirst().getDateOfBirth().toString())));
        verify(userService).getAllUsers();
    }

    @Test
    public void getUserByIdTest() throws Exception {
        var userDTO = userDtoBuilder.build();

        when(userService.getUserById(anyLong())).thenReturn(userDTO);

        mockMvc.perform(get("/users/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userDTO.getId()))
                .andExpect(jsonPath("$.name").value(userDTO.getName()))
                .andExpect(jsonPath("$.email").value(userDTO.getEmail()))
                .andExpect(jsonPath("$.address").value(userDTO.getAddress()))
                .andExpect(jsonPath("$.phoneNumber").value(userDTO.getPhoneNumber()))
                .andExpect(jsonPath("$.accountNumber").value(userDTO.getAccountNumber()))
                .andExpect(jsonPath("$.dateOfBirth", Matchers.startsWith(userDTO.getDateOfBirth().toString())));
        verify(userService).getUserById(anyLong());
    }

    @Test
    public void deleteUserTest() throws Exception {

        doNothing().when(userService).deleteUser(anyLong());

        mockMvc.perform(delete("/users/4"))
                .andExpect(status().isNoContent());

        verify(userService).deleteUser(anyLong());
    }

    @Test
    public void createUserTest() throws Exception {

        var userDTO = userDtoBuilder.build();
        var createUser = creationBuilder.build();

        when(userService.createUser(createUser)).thenReturn(userDTO);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(userDTO.getId()))
                .andExpect(jsonPath("$.name").value(userDTO.getName()))
                .andExpect(jsonPath("$.email").value(userDTO.getEmail()))
                .andExpect(jsonPath("$.address").value(userDTO.getAddress()))
                .andExpect(jsonPath("$.phoneNumber").value(userDTO.getPhoneNumber()))
                .andExpect(jsonPath("$.accountNumber").value(userDTO.getAccountNumber()))
                .andExpect(jsonPath("$.dateOfBirth", Matchers.startsWith(userDTO.getDateOfBirth().toString())));

        verify(userService).createUser(any(CreateUserDTO.class));
    }

    @Test
    public void updateUserTest() throws Exception {

        var creatUserDTO = creationBuilder.build();

        doNothing().when(userService).updateUser(anyLong(), any(CreateUserDTO.class));

        mockMvc.perform(put("/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(creatUserDTO)))
                .andExpect(status().isNoContent());

        verify(userService).updateUser(anyLong(), any(CreateUserDTO.class));
    }
}