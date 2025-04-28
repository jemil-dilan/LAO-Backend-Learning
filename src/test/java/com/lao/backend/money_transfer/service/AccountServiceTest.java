package com.lao.backend.money_transfer.service;

import com.lao.backend.money_transfer.domain.Account;
import com.lao.backend.money_transfer.domain.Transaction;
import com.lao.backend.money_transfer.dto.CreateAccountDTO;
import com.lao.backend.money_transfer.mapper.AccountMapper;
import com.lao.backend.money_transfer.repository.AccountRepository;
import com.lao.backend.money_transfer.repository.UserRepository;
import com.lao.backend.money_transfer.testBuilder.account.AccountBuilder;
import com.lao.backend.money_transfer.testBuilder.account.AccountDTOBuilder;
import com.lao.backend.money_transfer.testBuilder.account.CreateAccountBuilder;
import com.lao.backend.money_transfer.testBuilder.user.UserBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @Mock
    AccountRepository accountRepository;
    @Mock
    AccountMapper accountMapper;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    AccountService accountService;

    AccountBuilder accountBuilder = new AccountBuilder();
    AccountDTOBuilder accountDTOBuilder = new AccountDTOBuilder();
    CreateAccountBuilder createAccountBuilder = new CreateAccountBuilder();
    UserBuilder userBuilder = new UserBuilder();

    @Test
    void getAllAccountsTest(){
        var account = accountBuilder.build();
        var accountDTO = accountDTOBuilder.build();

        when(accountRepository.findAll()).thenReturn(List.of(account));
        when(accountMapper.toDTO(any(Account.class))).thenReturn(accountDTO);

        var result = accountService.getAllAccounts();

        assertEquals(accountDTO.getId(), result.getFirst().getId());
        assertEquals(accountDTO.getAccountNumber(), result.getFirst().getAccountNumber());
        assertEquals(accountDTO.getAccountTransactions(), result.getFirst().getAccountTransactions());
        assertEquals(accountDTO.getBalance(), result.getFirst().getBalance());
        assertEquals(accountDTO.getOwnerName(), result.getFirst().getOwnerName());
        assertThat(List.of(accountDTO)).isEqualTo(result);
        assertThat(result).hasSize(1).containsOnly(accountDTO);

        verify(accountRepository).findAll();
        verify(accountMapper).toDTO(any(Account.class));
    }
    @Test
    void getAccountByIdTest(){
        var account = accountBuilder.build();
        var accountDTO = accountDTOBuilder.build();

        when(accountRepository.findById(anyLong())).thenReturn(Optional.of(account));
        when(accountMapper.toDTO(any(Account.class))).thenReturn(accountDTO);

        var result = accountService.getAccountById(2L);

        assertEquals(accountDTO.getId(), result.getId());
        assertEquals(accountDTO.getAccountNumber(), result.getAccountNumber());
        assertEquals(accountDTO.getAccountTransactions(), result.getAccountTransactions());
        assertEquals(accountDTO.getBalance(), result.getBalance());
        assertEquals(accountDTO.getOwnerName(), result.getOwnerName());
        assertThat(accountDTO).isEqualTo(result);

        verify(accountRepository).findById(anyLong());
        verify(accountMapper).toDTO(any(Account.class));
    }

    @Test
    void deleteTest(){

        when(accountRepository.existsById(anyLong())).thenReturn(true);
        doNothing().when(accountRepository).deleteById(anyLong());

        accountService.deleteAccount(2L);

        verify(accountRepository).existsById(anyLong());
        verify(accountRepository).deleteById(anyLong());
    }

    @Test
    void createAccountTest(){
        var creatAccountDTO = createAccountBuilder.build();
        var user = userBuilder.build();
        var account = accountBuilder.build();
        var accountDTO = accountDTOBuilder.build();

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(user));
        when(accountMapper.toEntityByCreation(any(CreateAccountDTO.class))).thenReturn(account);
        when(accountRepository.save(any(Account.class))).thenReturn(account);
        when(accountMapper.toDTO(any(Account.class))).thenReturn(accountDTO);

        var result = accountService.createAccount(creatAccountDTO);

        assertEquals(accountDTO.getId(), result.getId());
        assertEquals(accountDTO.getAccountNumber(), result.getAccountNumber());
        assertEquals(accountDTO.getAccountTransactions(), result.getAccountTransactions());
        assertEquals(accountDTO.getBalance(), result.getBalance());
        assertEquals(accountDTO.getOwnerName(), result.getOwnerName());
        assertThat(accountDTO).isEqualTo(result);

        verify(userRepository).findById(anyLong());
        verify(accountMapper).toEntityByCreation(any(CreateAccountDTO.class));
        verify(accountRepository).save(any(Account.class));
        verify(accountMapper).toDTO(any(Account.class));
    }

    @Test
    void updateAccountTest(){
        var creatAccountDTO = createAccountBuilder.build();
        var account = accountBuilder.build();
        var accountDTO = accountDTOBuilder.build();

        when(accountRepository.existsById(anyLong())).thenReturn(true);
        when(accountMapper.toEntityByCreation(any(CreateAccountDTO.class))).thenReturn(account);
        when(accountRepository.save(any(Account.class))).thenReturn(account);
        when(accountRepository.findAll()).thenReturn(List.of(account));
        when(accountMapper.toDTO(any(Account.class))).thenReturn(accountDTO);

        accountService.updateAccount(1L, creatAccountDTO);
        var result = accountService.getAllAccounts();

        assertEquals(accountDTO.getId(), result.getFirst().getId());
        assertEquals(accountDTO.getAccountNumber(), result.getFirst().getAccountNumber());
        assertEquals(accountDTO.getAccountTransactions(), result.getFirst().getAccountTransactions());
        assertEquals(accountDTO.getBalance(), result.getFirst().getBalance());
        assertEquals(accountDTO.getOwnerName(), result.getFirst().getOwnerName());
        assertThat(List.of(accountDTO)).isEqualTo(result);
        assertThat(result).hasSize(1).containsOnly(accountDTO);

        verify(accountRepository).existsById(anyLong());
        verify(accountMapper).toEntityByCreation(any(CreateAccountDTO.class));
        verify(accountRepository).save(any(Account.class));
        verify(accountRepository).findAll();
        verify(accountMapper).toDTO(any(Account.class));
    }
}