package org.example.gestion_utilisateur.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.gestion_utilisateur.dto.CreateUserDTO;
import org.example.gestion_utilisateur.dto.UserDTO;
import org.example.gestion_utilisateur.service.UserService;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = UserController.class)
@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    UserService userService;

    private final String BASE_URL = "/users";

    @Test
    void getAllUsersTest() throws Exception {


        UserDTO userDTO = mock();
        UserDTO userDTO2 = mock();
        UserDTO userDTO3 = mock();
        when(userService.getAllUsers()).thenReturn(List.of(userDTO, userDTO2, userDTO3));

        mockMvc.perform(get(BASE_URL).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(3)));
    }

    @Test
    void getUserByIdTest() throws Exception {
        UserDTO userDTO = UserDTO.builder().id(1L).email("FOO@exzmplr.com").firstName("joe").lastName("boss").build();
        when(userService.getUserById(anyLong())).thenReturn(userDTO);

        mockMvc.perform(get(BASE_URL + "/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(userDTO.getId()))
                .andExpect(jsonPath("$.email").value(userDTO.getEmail()))
                .andExpect(jsonPath("$.firstName").value(userDTO.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(userDTO.getLastName()));
    }

    @Test
    void deleteUserTest() throws Exception {

        doNothing().when(userService).deleteUser(anyLong());

        mockMvc.perform(delete(BASE_URL + "/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
    @Test
    void  createUserTest() throws Exception {
        CreateUserDTO createUserDTO = CreateUserDTO.builder().email("FOO@exzmplr.com").firstName("joe").lastName("boss").build();
        UserDTO userDTO = UserDTO.builder().id(1L).email("FOO@exzmplr.com").firstName("joe").lastName("boss").build();

        when(userService.createUser(createUserDTO)).thenReturn(userDTO);

        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUserDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(userDTO.getId()))
                .andExpect(jsonPath("$.email").value(userDTO.getEmail()))
                .andExpect(jsonPath("$.firstName").value(userDTO.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(userDTO.getLastName()));
    }

    @Test
    void updateUserTest() throws Exception {
        CreateUserDTO createUserDTO = CreateUserDTO.builder().email("FOO@exzmplr.com").firstName("joe").lastName("boss").build();


        doNothing().when(userService).updateUser(2L, createUserDTO);

        mockMvc.perform(put(BASE_URL + "/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUserDTO)))
                .andExpect(status().isNoContent());
    }



}