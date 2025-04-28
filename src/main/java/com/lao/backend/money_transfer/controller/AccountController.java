package com.lao.backend.money_transfer.controller;

import com.lao.backend.money_transfer.dto.AccountDTO;
import com.lao.backend.money_transfer.dto.CreateAccountDTO;
import com.lao.backend.money_transfer.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
    @GetMapping("{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
        return ResponseEntity.ok(accountService.getAccountById(id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> getDeleteById(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody CreateAccountDTO createAccountDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(createAccountDTO));
    }
    @PutMapping("{id}")
    public ResponseEntity<Void> updateAccount(@PathVariable Long id, @RequestBody CreateAccountDTO createAccountDTO){
        accountService.updateAccount(id, createAccountDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
