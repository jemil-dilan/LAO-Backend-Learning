package com.laoBackend.gestionaire_de_biblioteque.service;

import com.laoBackend.gestionaire_de_biblioteque.domain.Book;
import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Status;
import com.laoBackend.gestionaire_de_biblioteque.domain.Member;
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
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

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
        return transactionMapper.toDTO(transactionRepository.findAll());
    }

    public List<TransactionDTO> getTransactionByStatus (Status status, Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian can obtain transactions");
        }
        return transactionMapper.toDTO(transactionRepository.findAllByStatus(status));
    }

    public TransactionDTO getTransactionById(Long id, Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian can obtain transactions");
        }
        return transactionMapper.toDTO(transactionRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User doesn't exist")));
    }

    public TransactionDTO borrowBook(Long memberId, Long bookId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if(!member.getRole().toString().equalsIgnoreCase("MEMBER")){
            throw new RuntimeException("Only a member can borrow a book");
        }
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        if (book.getAvailableCopies() <=0){
            throw new ResourceNotFoundException("No copies available");
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);
        Transaction transaction = new Transaction();
        transaction.setMember(member);
        transaction.setBook(book);
        transaction.setBorrowDate(LocalDateTime.now());
        transaction.setDueDate(LocalDateTime.now().plusWeeks(2));
        transaction.setReturnDate(null);
        transaction.setStatus(Status.BORROWED);
        return transactionMapper.toDTO(transactionRepository.save(transaction));
    }

    public TransactionDTO returnBook(Long transactionId) {
        Transaction transaction = transactionRepository.findById(transactionId)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
        if (transaction.getReturnDate() != null){
            throw new IllegalStateException("Book already returned");
        }
        Book book = transaction.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);
        transaction.setReturnDate(LocalDateTime.now());
        transaction.setStatus(Status.RETURNED);
        return transactionMapper.toDTO(transactionRepository.save(transaction));
    }

    public List<TransactionDTO> getUserTransactionHistory(Long memberId){
        return transactionMapper.toDTO(transactionRepository.findAllByMemberId(memberId));
    }

    public List<TransactionDTO> getBookTransactionHistory(Long bookId, Long memberId){
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian get transactions of a book");
        }
        return transactionMapper.toDTO(transactionRepository.findAllByBookId(bookId));
    }
    
}
