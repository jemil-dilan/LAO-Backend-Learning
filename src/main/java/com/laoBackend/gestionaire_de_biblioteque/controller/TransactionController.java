package com.laoBackend.gestionaire_de_biblioteque.controller;

import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Status;
import com.laoBackend.gestionaire_de_biblioteque.dto.TransactionDTO;
import com.laoBackend.gestionaire_de_biblioteque.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/transactions")
public class TransactionController {
    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransactions(@RequestParam Long memberId){
        List<TransactionDTO> allTransactions = transactionService.getAllTransactions(memberId);
        return ResponseEntity.ok(allTransactions);
    }

    @PostMapping("/borrow")
    public ResponseEntity<Void> borrowBook(@RequestParam Long memberId, @RequestParam Long bookId){
        transactionService.borrowBook(memberId, bookId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/return/{id}")
    public ResponseEntity<Void> returnBorrowedBook(@PathVariable Long id){
       transactionService.returnBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<TransactionDTO>> getTransactionByStatus(@PathVariable String status, @RequestParam Long memberId){
        try{
            Status transactionStatus = Status.valueOf(status.toUpperCase());
            List<TransactionDTO> transactionByStatus = transactionService.getTransactionByStatus(transactionStatus, memberId);
            return ResponseEntity.ok(transactionByStatus);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id, @RequestParam Long memberId){
        return ResponseEntity.ok(transactionService.getTransactionById(id, memberId));
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<List<TransactionDTO>> getUserHistory(@PathVariable Long id){
        return ResponseEntity.ok(transactionService.getUserTransactionHistory(id));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<List<TransactionDTO>> getBookHistory(@PathVariable Long id, @RequestParam Long memberId){
        return ResponseEntity.ok(transactionService.getBookTransactionHistory(id, memberId));
    }
}
