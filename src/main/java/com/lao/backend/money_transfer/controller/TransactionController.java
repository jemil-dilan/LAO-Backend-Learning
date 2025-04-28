package com.lao.backend.money_transfer.controller;

import com.lao.backend.money_transfer.dto.AccountDTO;
import com.lao.backend.money_transfer.dto.CreateAccountDTO;
import com.lao.backend.money_transfer.dto.TransactionDTO;
import com.lao.backend.money_transfer.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
     public ResponseEntity<List<TransactionDTO>> getAllTransactions(){
         return ResponseEntity.ok(transactionService.getAllTransaction());
     }
    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<TransactionDTO>> getAccountHistory(@PathVariable Long accountId){
        return ResponseEntity.ok(transactionService.getAccountTransactions(accountId));
    }
    @GetMapping("{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id){
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransactionDTO> createAccount(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestParam Integer amount){
        BigDecimal transactionAmount = BigDecimal.valueOf(amount);
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.transferMoney(senderId,receiverId,transactionAmount));
    }
}
