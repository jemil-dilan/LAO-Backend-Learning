package com.lao.backend.money_transfer.service;

import com.lao.backend.money_transfer.domain.Account;
import com.lao.backend.money_transfer.domain.User;
import com.lao.backend.money_transfer.dto.AccountDTO;
import com.lao.backend.money_transfer.dto.CreateAccountDTO;
import com.lao.backend.money_transfer.mapper.AccountMapper;
import com.lao.backend.money_transfer.repository.AccountRepository;
import com.lao.backend.money_transfer.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {

    private  AccountRepository accountRepository;
    private  AccountMapper accountMapper;
    private  UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.userRepository = userRepository;
    }

    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::toDTO).toList();
    }

    public AccountDTO getAccountById(Long accountId) {
        return accountRepository.findById(accountId).map(accountMapper::toDTO).orElseThrow();
    }

    public void deleteAccount(Long accountId) {
        if (accountRepository.existsById(accountId)){
            accountRepository.deleteById(accountId);
        }
    }

    public AccountDTO createAccount(CreateAccountDTO creatAccountDTO) {
        User user = userRepository.findById(creatAccountDTO.getUserId()).orElseThrow();
        Account account = accountMapper.toEntityByCreation(creatAccountDTO);
        account.setUser(user);
        if (!accountRepository.existsByAccountNumber(account.getAccountNumber())){
            account.setCreatedAt(LocalDateTime.now());
            return accountMapper.toDTO(accountRepository.save(account));
        }
        else {throw new RuntimeException("account already exist");}
    }
    public void updateAccount(Long accountId, CreateAccountDTO creatAccountDTO) {
        if(accountRepository.existsById(accountId)){
            Account entity = accountMapper.toEntityByCreation(creatAccountDTO);
            entity.setId(accountId);
            entity.setUpdatedTime(LocalDateTime.now());
            accountRepository.save(entity);
        }else {
            throw new RuntimeException("User doesn't exist");
        }
    }
}
