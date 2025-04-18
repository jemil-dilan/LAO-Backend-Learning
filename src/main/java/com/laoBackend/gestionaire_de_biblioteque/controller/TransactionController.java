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
    public ResponseEntity<List<TransactionDTO>> getAllBooks(@RequestParam Long memberId){
        return ResponseEntity.ok(transactionService.getAllTransactions(memberId));
    }

    @PostMapping("/borrow")
    public ResponseEntity<TransactionDTO> borrowBook(@RequestParam Long memberId, @RequestParam Long bookId){
        TransactionDTO transactionDTO = transactionService.borrowBook(memberId, bookId);
        return ResponseEntity.ok(transactionDTO);
    }

    @PutMapping("/return/{id}")
    public ResponseEntity<TransactionDTO> returnBorrowedBook(@PathVariable Long id){
        TransactionDTO returnedBook = transactionService.returnBook(id);
        return ResponseEntity.ok(returnedBook);
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<TransactionDTO>> getTransactionByStatus(@PathVariable String status, @RequestParam Long memberId){
        try{
            Status transactionStatus = Status.valueOf(status.toUpperCase());
            List<TransactionDTO> transactionByStatus = transactionService.getTransactionByStatus(transactionStatus, memberId);
            return transactionByStatus.isEmpty() ?
                    ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                    ResponseEntity.ok(transactionByStatus);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransactionById(@PathVariable Long id, @RequestParam Long memberId){
        TransactionDTO transactionById = transactionService.getTransactionById(id, memberId);
        return ResponseEntity.ok(transactionById);
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<List<TransactionDTO>> getUserHistory(@PathVariable Long id){
        List<TransactionDTO> userTransactionHistory = transactionService.getUserTransactionHistory(id);
        return ResponseEntity.ok(userTransactionHistory);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<List<TransactionDTO>> getBookHistory(@PathVariable Long id, @RequestParam Long memberId){
        List<TransactionDTO> bookTransactionHistory = transactionService.getBookTransactionHistory(id, memberId);
        return ResponseEntity.ok(bookTransactionHistory);
    }
}
