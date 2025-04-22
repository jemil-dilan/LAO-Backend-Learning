package com.laoBackend.gestionaire_de_biblioteque.service;

import com.laoBackend.gestionaire_de_biblioteque.domain.Book;
import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Role;
import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Status;
import com.laoBackend.gestionaire_de_biblioteque.domain.Member;
import com.laoBackend.gestionaire_de_biblioteque.domain.Transaction;
import com.laoBackend.gestionaire_de_biblioteque.dto.TransactionDTO;
import com.laoBackend.gestionaire_de_biblioteque.mapper.TransactionMapper;
import com.laoBackend.gestionaire_de_biblioteque.repository.BookRepository;
import com.laoBackend.gestionaire_de_biblioteque.repository.MemberRepository;
import com.laoBackend.gestionaire_de_biblioteque.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @Mock
    TransactionRepository transactionRepository;
    @Mock
    BookRepository bookRepository;
    @Mock
    MemberRepository memberRepository;
    @Mock
    TransactionMapper transactionMapper;
    @InjectMocks
    TransactionService transactionService;

    @Test
    void getAllTransactions() {
        long memberId = 2L;
        Member member = new Member(
                memberId,
                "Roy",
                "roy@email.com",
                "ndokoti",
                LocalDateTime.now().minusDays(5),
                null,
                Role.LIBRARIAN
        );
        Book book =new Book(
                1L,
                "snowfall",
                "franclin",
                "mapped",
                2014,
                5,
                9
        );
        Transaction transaction = new Transaction(
                member,
                book,
                LocalDateTime.of(2024,5,25,12,23),
                LocalDateTime.now(),
                null,
                Status.BORROWED
        );
        TransactionDTO transactionDTO = new TransactionDTO(
                1L,
                member.getName(),
                book.getTitle(),
                LocalDateTime.of(2024,5,25,12,23),
                LocalDateTime.now(),
                null,
                Status.BORROWED
        );

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));
        when(transactionRepository.findAll()).thenReturn(List.of(transaction));
        when(transactionMapper.toDTO_LIST(List.of(transaction)))
                .thenReturn(List.of(transactionDTO));

        List<TransactionDTO> result = transactionService
                .getAllTransactions(member.getId());

        assertEquals(1,result.size());
        assertThat(result).isEqualTo(List.of(transactionDTO));

        verify(memberRepository).findById(memberId);
        verify(transactionRepository).findAll();
        verify(transactionMapper).toDTO_LIST(List.of(transaction));
    }

    @Test
    void getTransactionByStatus() {
        long memberId = 3L;
        Member member = new Member(
                memberId,
                "Roy",
                "roy@email.com",
                "ndokoti",
                LocalDateTime.now().minusDays(5),
                null,
                Role.LIBRARIAN
        );
        Book book = new Book(
                1L,
                "snowfall",
                "franclin",
                "mapped",
                2014,
                5,
                9
        );
        Transaction transaction = new Transaction(
                member,
                book,
                LocalDateTime.of(2024,5,25,12,23),
                LocalDateTime.now(),
                null,
                Status.BORROWED
        );
        TransactionDTO transactionDTO = new TransactionDTO(
                1L,
                member.getName(),
                book.getTitle(),
                LocalDateTime.of(2024,5,25,12,23),
                LocalDateTime.now(),
                null,
                Status.BORROWED
        );
        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));
        when(transactionRepository.findAllByStatus(Status.BORROWED))
                .thenReturn(List.of(transaction));
        when(transactionMapper.toDTO_LIST(List.of(transaction)))
                .thenReturn(List.of(transactionDTO));

        List<TransactionDTO> result = transactionService
                .getTransactionByStatus(Status.BORROWED, memberId);

        assertEquals(List.of(transactionDTO).size(), result.size());
        assertThat(List.of(transactionDTO)).isEqualTo(result);

        verify(memberRepository).findById(memberId);
        verify(transactionRepository).findAllByStatus(Status.BORROWED);
        verify(transactionMapper).toDTO_LIST(List.of(transaction));
    }

    @Test
    void getTransactionById() {
        Long memberId = 3L;
        Member member = new Member(
                memberId,
                "Roy",
                "roy@email.com",
                "ndokoti",
                LocalDateTime.now().minusDays(5),
                null,
                Role.LIBRARIAN
        );
        Book book = new Book(
                1L,
                "snowfall",
                "franclin",
                "mapped",
                2014,
                5,
                9
        );
        Long transactionId = 2L;
        Transaction transaction = new Transaction(
                member,
                book,
                LocalDateTime.of(2024,5,25,12,23),
                LocalDateTime.now(),
                null,
                Status.BORROWED

        );
        TransactionDTO transactionDTO = new TransactionDTO(
                transactionId,
                member.getName(),
                book.getTitle(),
                LocalDateTime.of(2024,5,25,12,23),
                LocalDateTime.now(),
                null,
                Status.BORROWED
        );

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));
        when(transactionRepository.findById(transactionId))
                .thenReturn(Optional.of(transaction));
        when(transactionMapper.toDTO(transaction)).thenReturn(transactionDTO);

        TransactionDTO result = transactionService.getTransactionById(transactionId, memberId);

        assertEquals(transactionDTO.getBorrowDate(), result.getBorrowDate());
        assertThat(transactionDTO).isEqualTo(result);

        verify(memberRepository).findById(memberId);
        verify(transactionRepository).findById(transactionId);
        verify(transactionMapper).toDTO(transaction);
    }


    @Test
    void borrowBook() {
        Long memberId = 2L;
        Member member = new Member(
                memberId,
                "Roy",
                "roy@email.com",
                "ndokoti",
                LocalDateTime.now().minusDays(5),
                null,
                Role.MEMBER
        );
        long bookId = 1L;
        Book book = new Book(
                bookId,
                "snowfall",
                "franclin",
                "mapped",
                2014,
                5,
                9
        );
        LocalDateTime borrowDate = LocalDateTime.of(2025,3,25,12,23);
        LocalDateTime dueDate = borrowDate.plusWeeks(2);
        Transaction transaction = new Transaction(
                member,
                book,
                borrowDate,
                dueDate,
                null,
                Status.BORROWED
        );
        TransactionDTO transactionDTO = new TransactionDTO(
                1L,
                member.getName(),
                book.getTitle(),
                borrowDate,
                dueDate,
                null,
                Status.BORROWED
        );

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        when(bookRepository.save(book)).thenReturn(book);
        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);
        when(transactionMapper.toDTO(any(Transaction.class))).thenReturn(transactionDTO);

        TransactionDTO result = transactionService.borrowBook(memberId, bookId);

        assertEquals(transactionDTO.getBorrowDate(), result.getBorrowDate());
        assertThat(transactionDTO).isEqualTo(result);

        verify(memberRepository).findById(memberId);
        verify(bookRepository).findById(bookId);
        verify(bookRepository).save(book);
        verify(transactionRepository).save(any(Transaction.class));
        verify(transactionMapper).toDTO(any(Transaction.class));

    }

    @Test
    void returnBook() {
        LocalDateTime borrowDate = LocalDateTime.of(2025,3,25,12,23);
        LocalDateTime dueDate = borrowDate.plusWeeks(2);
        long memberId = 2L;
        Member member = new Member(
                memberId,
                "Roy",
                "roy@email.com",
                "ndokoti",
                LocalDateTime.now().minusDays(5),
                null,
                Role.MEMBER
        );
        long bookId = 1L;
        Book book = new Book(
                bookId,
                "snowfall",
                "franclin",
                "mapped",
                2014,
                5,
                9
        );
        Transaction transaction = new Transaction(
                member,
                book,
                borrowDate,
                dueDate,
                null,
                Status.BORROWED
        );
        Transaction updatedTransaction = new Transaction(
                member,
                book,
                borrowDate,
                dueDate,
                LocalDateTime.of(2025,4,22,12,30),
                Status.RETURNED
        );
        TransactionDTO transactionDTO = new TransactionDTO(
                1L,
                member.getName(),
                book.getTitle(),
                borrowDate,
                dueDate,
                LocalDateTime.of(2025,4,22,12,30),
                Status.RETURNED
        );

        when(transactionRepository.findById(anyLong())).thenReturn(Optional.of(transaction));

        book.setAvailableCopies(book.getAvailableCopies() + 1);
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        when(transactionRepository.save(any(Transaction.class))).thenReturn(updatedTransaction);
        when(transactionMapper.toDTO(updatedTransaction)).thenReturn(transactionDTO);

        TransactionDTO result = transactionService.returnBook(1L);

        assertEquals(transactionDTO.getReturnDate(), result.getReturnDate());

        verify(transactionRepository).findById(anyLong());
        verify(bookRepository).save(any(Book.class));
        verify(transactionRepository).save(any(Transaction.class));
        verify(transactionMapper).toDTO(updatedTransaction);


    }

    @Test
    void getUserTransactionHistory() {
        long memberId = 2L;
        Member member = new Member(
                memberId,
                "Roy",
                "roy@email.com",
                "ndokoti",
                LocalDateTime.now().minusDays(5),
                null,
                Role.LIBRARIAN
        );
        Book book =new Book(
                1L,
                "snowfall",
                "franclin",
                "mapped",
                2014,
                5,
                9
        );
        Transaction transaction = new Transaction(
                member,
                book,
                LocalDateTime.of(2024,5,25,12,23),
                LocalDateTime.now(),
                null,
                Status.BORROWED
        );
        TransactionDTO transactionDTO = new TransactionDTO(
                1L,
                member.getName(),
                book.getTitle(),
                LocalDateTime.of(2024,5,25,12,23),
                LocalDateTime.now(),
                null,
                Status.BORROWED
        );

        when(transactionRepository.findAllByMemberId(memberId)).thenReturn(List.of(transaction));
        when(transactionMapper.toDTO_LIST(List.of(transaction))).thenReturn(List.of(transactionDTO));

        List<TransactionDTO> result = transactionService.getUserTransactionHistory(memberId);

        assertEquals(result.size(), List.of(transaction).size());
    }

    @Test
    void getBookTransactionHistory() {
        long memberId = 2L;
        Member member = new Member(
                memberId,
                "Roy",
                "roy@email.com",
                "ndokoti",
                LocalDateTime.now().minusDays(5),
                null,
                Role.LIBRARIAN
        );
        long bookId = 1L;
        Book book =new Book(
                bookId,
                "snowfall",
                "franclin",
                "mapped",
                2014,
                5,
                9
        );
        Transaction transaction = new Transaction(
                member,
                book,
                LocalDateTime.of(2024,5,25,12,23),
                LocalDateTime.now(),
                null,
                Status.BORROWED
        );
        TransactionDTO transactionDTO = new TransactionDTO(
                1L,
                member.getName(),
                book.getTitle(),
                LocalDateTime.of(2024,5,25,12,23),
                LocalDateTime.now(),
                null,
                Status.BORROWED
        );

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));
        when(transactionRepository.findAllByBookId(bookId))
                .thenReturn(List.of(transaction));
        when(transactionMapper.toDTO_LIST(List.of(transaction)))
                .thenReturn(List.of(transactionDTO));

        List<TransactionDTO> result = transactionService.getBookTransactionHistory(bookId, memberId);

        assertAll(() -> {
            assertEquals(List.of(transactionDTO).size(),result.size());
            assertThat(result).isEqualTo(List.of(transactionDTO));
        });

        verify(memberRepository).findById(memberId);
        verify(transactionRepository).findAllByBookId(bookId);
        verify(transactionMapper).toDTO_LIST(List.of(transaction));
    }
}