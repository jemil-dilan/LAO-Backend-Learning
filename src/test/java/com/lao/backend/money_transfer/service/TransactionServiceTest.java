package com.lao.backend.money_transfer.service;

import com.lao.backend.money_transfer.domain.Transaction;
import com.lao.backend.money_transfer.domain.User;
import com.lao.backend.money_transfer.mapper.TransactionMapper;
import com.lao.backend.money_transfer.repository.AccountRepository;
import com.lao.backend.money_transfer.repository.TransactionRepository;
import com.lao.backend.money_transfer.testBuilder.account.AccountBuilder;
import com.lao.backend.money_transfer.testBuilder.transaction.TransactionBuilder;
import com.lao.backend.money_transfer.testBuilder.transaction.TransactionDTOBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @Mock
    TransactionRepository transactionRepository;
    @Mock
    TransactionMapper transactionMapper;
    @Mock
    AccountRepository accountRepository;
    @InjectMocks
    TransactionService transactionService;

    TransactionBuilder transactionBuilder = new TransactionBuilder();
    TransactionDTOBuilder transactionDTOBuilder = new TransactionDTOBuilder();
    AccountBuilder accountBuilder = new AccountBuilder();

    @Test
    void getAllTransactionsTest(){
        var transaction = transactionBuilder.build();
        var transactionDTO = transactionDTOBuilder.build();

        when(transactionRepository.findAll()).thenReturn(List.of(transaction));
        when(transactionMapper.toDTO(any(Transaction.class))).thenReturn(transactionDTO);

        var result = transactionService.getAllTransaction();

        assertEquals(transactionDTO.getId(), result.getFirst().getId());
        assertEquals(transactionDTO.getAmount(), result.getFirst().getAmount());
        assertEquals(transactionDTO.getStatus(), result.getFirst().getStatus());
        assertEquals(transactionDTO.getReference(), result.getFirst().getReference());
        assertEquals(transactionDTO.getSenderAccountId(), result.getFirst().getSenderAccountId());
        assertEquals(transactionDTO.getReceiverAccountId(), result.getFirst().getReceiverAccountId());
        assertEquals(transactionDTO.getCreationDate(), result.getFirst().getCreationDate());
        assertThat(List.of(transactionDTO)).isEqualTo(result);
        assertThat(result).hasSize(1).containsOnly(transactionDTO);

        verify(transactionRepository).findAll();
        verify(transactionMapper).toDTO(any(Transaction.class));
    }

    @Test
    void getTransactionById(){
        var transaction = transactionBuilder.build();
        var transactionDTO = transactionDTOBuilder.build();

        when(transactionRepository.findById(anyLong())).thenReturn(Optional.of(transaction));
        when(transactionMapper.toDTO(any(Transaction.class))).thenReturn(transactionDTO);

        var result = transactionService.getTransactionById(2L);

        assertEquals(transactionDTO.getId(), result.getId());
        assertEquals(transactionDTO.getAmount(), result.getAmount());
        assertEquals(transactionDTO.getStatus(), result.getStatus());
        assertEquals(transactionDTO.getReference(), result.getReference());
        assertEquals(transactionDTO.getSenderAccountId(), result.getSenderAccountId());
        assertEquals(transactionDTO.getReceiverAccountId(), result.getReceiverAccountId());
        assertThat(transactionDTO).isEqualTo(result);


        verify(transactionRepository).findById(anyLong());
        verify(transactionMapper).toDTO(any(Transaction.class));
    }

    @Test
    void getAccountTransaction(){
        var account = accountBuilder.build();
        var transaction = transactionBuilder.build();
        var transactionDTO = transactionDTOBuilder.build();

        when(accountRepository.findById(anyLong())).thenReturn(Optional.of(account));
        when(transactionRepository.findAllBySenderAccountOrReceiverAccount(account, account))
                .thenReturn(List.of(transaction));
        when(transactionMapper.toDTO(transaction)).thenReturn(transactionDTO);

        var result = transactionService.getAccountTransactions(2L);

        assertEquals(transactionDTO.getId(), result.getFirst().getId());
        assertEquals(transactionDTO.getAmount(), result.getFirst().getAmount());
        assertEquals(transactionDTO.getStatus(), result.getFirst().getStatus());
        assertEquals(transactionDTO.getReference(), result.getFirst().getReference());
        assertEquals(transactionDTO.getSenderAccountId(), result.getFirst().getSenderAccountId());
        assertEquals(transactionDTO.getReceiverAccountId(), result.getFirst().getReceiverAccountId());
        assertThat(List.of(transactionDTO)).isEqualTo(result);
        assertThat(result).hasSize(1).containsOnly(transactionDTO);

        verify(accountRepository).findById(anyLong());
        verify(transactionRepository).findAllBySenderAccountOrReceiverAccount(account,account);
        verify(transactionMapper).toDTO(transaction);
    }

    @Test
    void transferMoneyTest(){
        var account = accountBuilder.build();
        var account1 = accountBuilder.withBalance((BigDecimal.valueOf(2000))).withId(4L)
                .build();
        var transaction = transactionBuilder.withSenderAccount(account).withReceiverAccount(account1).build();
        var transactionDTO = transactionDTOBuilder.build();

        when(accountRepository.findById(account.getId())).thenReturn(Optional.of(account));
        when(accountRepository.findById(account1.getId())).thenReturn(Optional.of(account1));
        when(accountRepository.save(account)).thenReturn(account);
        when(accountRepository.save(account1)).thenReturn(account1);
        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);
        when(transactionMapper.toDTO(any(Transaction.class))).thenReturn(transactionDTO);

        var result = transactionService.transferMoney(account.getId(), account1.getId(), BigDecimal.valueOf(1000));

        assertEquals(transactionDTO.getId(), result.getId());
        assertEquals(transactionDTO.getAmount(), result.getAmount());
        assertEquals(transactionDTO.getStatus(), result.getStatus());
        assertEquals(transactionDTO.getReference(), result.getReference());
        assertEquals(transactionDTO.getSenderAccountId(), result.getSenderAccountId());
        assertEquals(transactionDTO.getReceiverAccountId(), result.getReceiverAccountId());
        assertThat(transactionDTO).isEqualTo(result);

        verify(accountRepository).findById(account.getId());
        verify(accountRepository).findById(account1.getId());
        verify(accountRepository).save(account);
        verify(accountRepository).save(account1);
        verify(transactionRepository).save(any(Transaction.class));
        verify(transactionMapper).toDTO(any(Transaction.class));
    }
}