package com.laoBackend.gestionaire_de_biblioteque.service;

import com.laoBackend.gestionaire_de_biblioteque.domain.Book;
import com.laoBackend.gestionaire_de_biblioteque.domain.Member;
import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Status;
import com.laoBackend.gestionaire_de_biblioteque.domain.Transaction;
import com.laoBackend.gestionaire_de_biblioteque.dto.TransactionDTO;
import com.laoBackend.gestionaire_de_biblioteque.mapper.TransactionMapper;
import com.laoBackend.gestionaire_de_biblioteque.repository.BookRepository;
import com.laoBackend.gestionaire_de_biblioteque.repository.MemberRepository;
import com.laoBackend.gestionaire_de_biblioteque.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {
    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    private TransactionRepository transactionRepository;
    private TransactionMapper transactionMapper;

    public TransactionService(BookRepository bookRepository, MemberRepository memberRepository, TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    public List<TransactionDTO> getAllTransactions(Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian can get all the transactions");
        }
        List<Transaction> allTransactions = transactionRepository.findAll();
        return transactionMapper.toDTO_LIST(allTransactions);
    }

    public List<TransactionDTO> getTransactionByStatus (Status status, Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian can obtain transactions");
        }
        List<Transaction> allTransactionByStatus = transactionRepository.findAllByStatus(status);
        return transactionMapper.toDTO_LIST(allTransactionByStatus);
    }

    public TransactionDTO getTransactionById(Long id, Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian can obtain transactions");
        }
        Transaction transaction = transactionRepository.findById(id).orElseThrow();
        return transactionMapper.toDTO(transaction);
    }

    public TransactionDTO borrowBook(Long memberId, Long bookId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException("User not found"));
        if(!member.getRole().toString().equalsIgnoreCase("MEMBER")){
            throw new RuntimeException("Only a member can borrow a book");
        }
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book not found"));

        if (book.getAvailableCopies() <=0){
            throw new IllegalStateException("No copies available");
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
        Transaction transaction = new Transaction(
                member,
                book,
                LocalDateTime.now(),
                LocalDateTime.now().plusWeeks(2),
                Status.BORROWED);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return transactionMapper.toDTO(savedTransaction);
    }

    public TransactionDTO returnBook(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new IllegalStateException("Transaction not found"));
        if (transaction.getReturnDate() != null){
            throw new IllegalStateException("Book already returned");
        }
        Book book = transaction.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);
        transaction.setReturnDate(LocalDateTime.now());
        transaction.setStatus(Status.RETURNED);
        Transaction updated =transactionRepository.save(transaction);
        return transactionMapper.toDTO(updated);
    }

    public List<TransactionDTO> getUserTransactionHistory(Long memberId){
        List<Transaction> allTransactionForUser = transactionRepository.findAllByMemberId(memberId);
        return transactionMapper.toDTO_LIST(allTransactionForUser);
    }

    public List<TransactionDTO> getBookTransactionHistory(Long bookId, Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian get transactions of a book");
        }
        List<Transaction> allByBookId = transactionRepository.findAllByBookId(bookId);
        return transactionMapper.toDTO_LIST(allByBookId);
    }
    
}
