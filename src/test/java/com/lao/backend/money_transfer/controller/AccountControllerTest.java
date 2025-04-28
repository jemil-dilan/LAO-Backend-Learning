package com.lao.backend.money_transfer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lao.backend.money_transfer.dto.AccountDTO;
import com.lao.backend.money_transfer.dto.CreateAccountDTO;
import com.lao.backend.money_transfer.service.AccountService;
import com.lao.backend.money_transfer.testBuilder.account.AccountDTOBuilder;
import com.lao.backend.money_transfer.testBuilder.account.CreateAccountBuilder;
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

@WebMvcTest(AccountController.class)
@ExtendWith(MockitoExtension.class)
class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    AccountService accountService;


    AccountDTOBuilder accountDTOBuilder = new AccountDTOBuilder();
    CreateAccountBuilder createAccountBuilder = new CreateAccountBuilder();

    @Test
    public void getAllAccountsTest() throws Exception {
        List<AccountDTO> accountDTOList = List.of(accountDTOBuilder.build());

        when(accountService.getAllAccounts()).thenReturn(accountDTOList);

        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].id").value(accountDTOList.getFirst().getId()))
                .andExpect(jsonPath("$[0].accountNumber").value(accountDTOList.getFirst().getAccountNumber()))
                .andExpect(jsonPath("$[0].accountTransactions").value(accountDTOList.getFirst().getAccountTransactions()))
                .andExpect(jsonPath("$[0].balance").value(accountDTOList.getFirst().getBalance()))
                .andExpect(jsonPath("$[0].ownerName").value(accountDTOList.getFirst().getOwnerName()));

        verify(accountService).getAllAccounts();
    }

    @Test
    public void getAccountByIdTest() throws Exception {
        var accountDTO = accountDTOBuilder.build();

        when(accountService.getAccountById(anyLong())).thenReturn(accountDTO);

        mockMvc.perform(get("/accounts/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(accountDTO.getId()))
                .andExpect(jsonPath("$.accountNumber").value(accountDTO.getAccountNumber()))
                .andExpect(jsonPath("$.accountTransactions").value(accountDTO.getAccountTransactions()))
                .andExpect(jsonPath("$.balance").value(accountDTO.getBalance()))
                .andExpect(jsonPath("$.ownerName").value(accountDTO.getOwnerName()));

        verify(accountService).getAccountById(anyLong());
    }

    @Test
    public void deleteAccountBTest() throws Exception {

        doNothing().when(accountService).deleteAccount(anyLong());

        mockMvc.perform(delete("/accounts/4"))
                .andExpect(status().isNoContent());

        verify(accountService).deleteAccount(anyLong());
    }

    @Test
    public void createAccountTest() throws Exception {

        var accountDTO = accountDTOBuilder.build();

        when(accountService.createAccount(any(CreateAccountDTO.class))).thenReturn(accountDTO);

        mockMvc.perform(post("/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(accountDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(accountDTO.getId()))
                .andExpect(jsonPath("$.accountNumber").value(accountDTO.getAccountNumber()))
                .andExpect(jsonPath("$.accountTransactions").value(accountDTO.getAccountTransactions()))
                .andExpect(jsonPath("$.balance").value(accountDTO.getBalance()))
                .andExpect(jsonPath("$.ownerName").value(accountDTO.getOwnerName()));

        verify(accountService).createAccount(any(CreateAccountDTO.class));
    }

    @Test
    public void updateAccountTest() throws Exception {

        var createAccountDTO = createAccountBuilder.build();

        doNothing().when(accountService).updateAccount(anyLong(), any(CreateAccountDTO.class));

        mockMvc.perform(put("/accounts/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createAccountDTO)))
                .andExpect(status().isNoContent());

        verify(accountService).updateAccount(anyLong(), any(CreateAccountDTO.class));
    }

}