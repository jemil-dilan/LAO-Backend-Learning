package com.lao.backend.money_transfer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lao.backend.money_transfer.dto.TransactionDTO;
import com.lao.backend.money_transfer.service.TransactionService;
import com.lao.backend.money_transfer.testBuilder.transaction.TransactionBuilder;
import com.lao.backend.money_transfer.testBuilder.transaction.TransactionDTOBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
@ExtendWith(MockitoExtension.class)
class TransactionControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockitoBean
    TransactionService transactionService;

    TransactionDTOBuilder transactionDTOBuilder = new TransactionDTOBuilder();

    @Test
    public void getAllTransactionsTest() throws Exception {
        List<TransactionDTO> transactionDTOList = List.of(transactionDTOBuilder.build());

        when(transactionService.getAllTransaction()).thenReturn(transactionDTOList);

        mockMvc.perform(get("/transactions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].id").value(transactionDTOList.getFirst().getId()))
                .andExpect(jsonPath("$[0].amount").value(transactionDTOList.getFirst().getAmount()))
                .andExpect(jsonPath("$[0].status").value(transactionDTOList.getFirst().getStatus().toString()))
                .andExpect(jsonPath("$[0].reference").value(transactionDTOList.getFirst().getReference()))
                .andExpect(jsonPath("$[0].receiverAccountId").value(transactionDTOList.getFirst().getReceiverAccountId()))
                .andExpect(jsonPath("$[0].senderAccountId").value(transactionDTOList.getFirst().getSenderAccountId()))
                .andExpect(jsonPath("$[0].creationDate", Matchers.startsWith(transactionDTOList.getFirst().getCreationDate().toString())));

        verify(transactionService).getAllTransaction();
    }

    @Test
    public void getTransactionByIdTest() throws Exception {
        var transactionDTO = transactionDTOBuilder.build();

        when(transactionService.getTransactionById(anyLong())).thenReturn(transactionDTO);

        mockMvc.perform(get("/transactions/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(transactionDTO.getId()))
                .andExpect(jsonPath("$.amount").value(transactionDTO.getAmount()))
                .andExpect(jsonPath("$.status").value(transactionDTO.getStatus().toString()))
                .andExpect(jsonPath("$.reference").value(transactionDTO.getReference()))
                .andExpect(jsonPath("$.receiverAccountId").value(transactionDTO.getReceiverAccountId()))
                .andExpect(jsonPath("$.senderAccountId").value(transactionDTO.getSenderAccountId()))
                .andExpect(jsonPath("$.creationDate", Matchers.startsWith(transactionDTO.getCreationDate().toString())));

        verify(transactionService).getTransactionById(anyLong());
    }

    @Test
    public void getTAccountHistoryTest() throws Exception {
        var transactionDTOList = List.of(transactionDTOBuilder.build());

        when(transactionService.getAccountTransactions(anyLong())).thenReturn(transactionDTOList);

        mockMvc.perform(get("/transactions/account/4"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].id").value(transactionDTOList.getFirst().getId()))
                .andExpect(jsonPath("$[0].amount").value(transactionDTOList.getFirst().getAmount()))
                .andExpect(jsonPath("$[0].status").value(transactionDTOList.getFirst().getStatus().toString()))
                .andExpect(jsonPath("$[0].reference").value(transactionDTOList.getFirst().getReference()))
                .andExpect(jsonPath("$[0].receiverAccountId").value(transactionDTOList.getFirst().getReceiverAccountId()))
                .andExpect(jsonPath("$[0].senderAccountId").value(transactionDTOList.getFirst().getSenderAccountId()))
                .andExpect(jsonPath("$[0].creationDate", Matchers.startsWith(transactionDTOList.getFirst().getCreationDate().toString())));

        verify(transactionService).getAccountTransactions(anyLong());
    }


    @Test
    public void transferMoneyTest() throws Exception {

        var transactionDTO = transactionDTOBuilder.build();

        when(transactionService.transferMoney(anyLong(), anyLong(), any(BigDecimal.class)))
                .thenReturn(transactionDTO);

        mockMvc.perform(post("/transactions/transfer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("senderId","5")
                        .param("receiverId","3")
                        .param("amount","1000")
                        .content(objectMapper.writeValueAsString(transactionDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(transactionDTO.getId()))
                .andExpect(jsonPath("$.amount").value(transactionDTO.getAmount()))
                .andExpect(jsonPath("$.status").value(transactionDTO.getStatus().toString()))
                .andExpect(jsonPath("$.reference").value(transactionDTO.getReference()))
                .andExpect(jsonPath("$.receiverAccountId").value(transactionDTO.getReceiverAccountId()))
                .andExpect(jsonPath("$.senderAccountId").value(transactionDTO.getSenderAccountId()))
                .andExpect(jsonPath("$.creationDate", Matchers.startsWith(transactionDTO.getCreationDate().toString())));

        verify(transactionService).transferMoney(anyLong(), anyLong(), any(BigDecimal.class));
    }


}