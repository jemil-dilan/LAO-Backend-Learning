package com.laoBackend.gestionaire_de_biblioteque.service;

import com.laoBackend.gestionaire_de_biblioteque.domain.Book;
import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Role;
import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Status;
import com.laoBackend.gestionaire_de_biblioteque.domain.Transaction;
import com.laoBackend.gestionaire_de_biblioteque.dto.TransactionDTO;
import com.laoBackend.gestionaire_de_biblioteque.mapper.TransactionMapper;
import com.laoBackend.gestionaire_de_biblioteque.repository.BookRepository;
import com.laoBackend.gestionaire_de_biblioteque.repository.MemberRepository;
import com.laoBackend.gestionaire_de_biblioteque.repository.TransactionRepository;
import com.laoBackend.gestionaire_de_biblioteque.testBuilders.MemberBuilder;
import com.laoBackend.gestionaire_de_biblioteque.testBuilders.TransactionBuilder;
import com.laoBackend.gestionaire_de_biblioteque.testBuilders.TransactionDTOBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    TransactionBuilder transactionBuilder = new TransactionBuilder();
    TransactionDTOBuilder transactionDTOBuilder = new TransactionDTOBuilder();

    MemberBuilder memberBuilder = new MemberBuilder().withRole(Role.LIBRARIAN);

    @Test
    void getAllTransactions() {
        Transaction transaction = transactionBuilder.withMember(memberBuilder.build()).build();
        TransactionDTO transactionDTO = transactionDTOBuilder.build();

        when(memberRepository.findById(anyLong())).thenReturn(Optional.of(transaction.getMember()));
        when(transactionRepository.findAll()).thenReturn(List.of(transaction));
        when(transactionMapper.toDTO(List.of(transaction))).thenReturn(List.of(transactionDTO));

        List<TransactionDTO> result = transactionService.getAllTransactions(2L);

        assertEquals(transactionDTO.getId(), result.getFirst().getId());
        assertEquals(transactionDTO.getBookTitle(), result.getFirst().getBookTitle());
        assertEquals(transactionDTO.getMemberName(), result.getFirst().getMemberName());
        assertEquals(transactionDTO.getStatus(), result.getFirst().getStatus());
        assertEquals(transactionDTO.getBorrowDate(), result.getFirst().getBorrowDate());
        assertEquals(transactionDTO.getDueDate(), result.getFirst().getDueDate());
        assertEquals(transactionDTO.getReturnDate(), result.getFirst().getReturnDate());
        assertThat(result).hasSize(1).contains(transactionDTO);

        verify(memberRepository).findById(anyLong());
        verify(transactionRepository).findAll();
        verify(transactionMapper).toDTO(List.of(transaction));
    }

    @Test
    void getTransactionByStatus() {
        Transaction transaction = transactionBuilder.withMember(memberBuilder.build()).build();
        TransactionDTO transactionDTO = transactionDTOBuilder.build();
        when(memberRepository.findById(anyLong())).thenReturn(Optional.of(transaction.getMember()));
        when(transactionRepository.findAllByStatus(Status.BORROWED)).thenReturn(List.of(transaction));
        when(transactionMapper.toDTO(List.of(transaction))).thenReturn(List.of(transactionDTO));

        List<TransactionDTO> result = transactionService
                .getTransactionByStatus(Status.BORROWED, 1L);

        assertEquals(transactionDTO.getId(), result.getFirst().getId());
        assertEquals(transactionDTO.getBookTitle(), result.getFirst().getBookTitle());
        assertEquals(transactionDTO.getMemberName(), result.getFirst().getMemberName());
        assertEquals(transactionDTO.getStatus(), result.getFirst().getStatus());
        assertEquals(transactionDTO.getBorrowDate(), result.getFirst().getBorrowDate());
        assertEquals(transactionDTO.getDueDate(), result.getFirst().getDueDate());
        assertEquals(transactionDTO.getReturnDate(), result.getFirst().getReturnDate());
        assertThat(result).hasSize(1).contains(transactionDTO);

        verify(memberRepository).findById(anyLong());
        verify(transactionRepository).findAllByStatus(Status.BORROWED);
        verify(transactionMapper).toDTO(List.of(transaction));
    }

    @Test
    void getTransactionById() {
        Transaction transaction = transactionBuilder.withMember(memberBuilder.build()).build();
        TransactionDTO transactionDTO = transactionDTOBuilder.build();

        when(memberRepository.findById(anyLong())).thenReturn(Optional.of(transaction.getMember()));
        when(transactionRepository.findById(anyLong()))
                .thenReturn(Optional.of(transaction));
        when(transactionMapper.toDTO(any(Transaction.class))).thenReturn(transactionDTO);

        TransactionDTO result = transactionService.getTransactionById(1L, 2L);

        assertEquals(transactionDTO.getId(), result.getId());
        assertEquals(transactionDTO.getBookTitle(), result.getBookTitle());
        assertEquals(transactionDTO.getMemberName(), result.getMemberName());
        assertEquals(transactionDTO.getStatus(), result.getStatus());
        assertEquals(transactionDTO.getBorrowDate(), result.getBorrowDate());
        assertEquals(transactionDTO.getDueDate(), result.getDueDate());
        assertEquals(transactionDTO.getReturnDate(), result.getReturnDate());
        assertThat(result).isEqualTo(transactionDTO);

        verify(memberRepository).findById(anyLong());
        verify(transactionRepository).findById(anyLong());
        verify(transactionMapper).toDTO(any(Transaction.class));
    }


    @Test
    void borrowBook() {
        Transaction transaction = transactionBuilder.build();
        TransactionDTO transactionDTO = transactionDTOBuilder.build();

        when(memberRepository.findById(anyLong())).thenReturn(Optional.of(transaction.getMember()));
        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(transaction.getBook()));

        transaction.getBook().setAvailableCopies(transaction.getBook().getAvailableCopies() - 1);
        when(bookRepository.save(any(Book.class))).thenReturn(transaction.getBook());
        when(transactionRepository.save(any(Transaction.class))).thenReturn(transaction);
        when(transactionMapper.toDTO(any(Transaction.class))).thenReturn(transactionDTO);

        TransactionDTO result = transactionService.borrowBook(2L, 1L);

        assertEquals(transactionDTO.getId(), result.getId());
        assertEquals(transactionDTO.getBookTitle(), result.getBookTitle());
        assertEquals(transactionDTO.getMemberName(), result.getMemberName());
        assertEquals(transactionDTO.getStatus(), result.getStatus());
        assertEquals(transactionDTO.getBorrowDate(), result.getBorrowDate());
        assertEquals(transactionDTO.getDueDate(), result.getDueDate());
        assertEquals(transactionDTO.getReturnDate(), result.getReturnDate());
        assertThat(result).isEqualTo(transactionDTO);

        verify(memberRepository).findById(anyLong());
        verify(bookRepository).findById(anyLong());
        verify(bookRepository).save(any(Book.class));
        verify(transactionRepository).save(any(Transaction.class));
        verify(transactionMapper).toDTO(any(Transaction.class));

    }

    @Test
    void returnBook() {

        Transaction transaction = transactionBuilder.build();
        Transaction updatedTransaction = transactionBuilder.withReturnDate(LocalDateTime.of(2025,4,22,12,30)).build();
        TransactionDTO transactionDTO = transactionDTOBuilder.withReturnDate(LocalDateTime.of(2025,4,22,12,30)).build();

        when(transactionRepository.findById(anyLong())).thenReturn(Optional.of(transaction));

        updatedTransaction.getBook().setAvailableCopies(updatedTransaction.getBook().getAvailableCopies() + 1);
        when(bookRepository.save(any(Book.class))).thenReturn(updatedTransaction.getBook());

        when(transactionRepository.save(any(Transaction.class))).thenReturn(updatedTransaction);
        when(transactionMapper.toDTO(any(Transaction.class))).thenReturn(transactionDTO);

        TransactionDTO result = transactionService.returnBook(1L);

        assertEquals(transactionDTO.getId(), result.getId());
        assertEquals(transactionDTO.getBookTitle(), result.getBookTitle());
        assertEquals(transactionDTO.getMemberName(), result.getMemberName());
        assertEquals(transactionDTO.getStatus(), result.getStatus());
        assertEquals(transactionDTO.getBorrowDate(), result.getBorrowDate());
        assertEquals(transactionDTO.getDueDate(), result.getDueDate());
        assertEquals(transactionDTO.getReturnDate(), result.getReturnDate());
        assertThat(result).isEqualTo(transactionDTO);

        verify(transactionRepository).findById(anyLong());
        verify(bookRepository).save(any(Book.class));
        verify(transactionRepository).save(any(Transaction.class));
        verify(transactionMapper).toDTO(any(Transaction.class));


    }

    @Test
    void getUserTransactionHistory() {

        Transaction transaction = transactionBuilder.build();
        TransactionDTO transactionDTO = transactionDTOBuilder.build();

        when(transactionRepository.findAllByMemberId(anyLong())).thenReturn(List.of(transaction));
        when(transactionMapper.toDTO(List.of(transaction))).thenReturn(List.of(transactionDTO));

        List<TransactionDTO> result = transactionService.getUserTransactionHistory(2L);

        assertEquals(transactionDTO.getId(), result.getFirst().getId());
        assertEquals(transactionDTO.getBookTitle(), result.getFirst().getBookTitle());
        assertEquals(transactionDTO.getMemberName(), result.getFirst().getMemberName());
        assertEquals(transactionDTO.getStatus(), result.getFirst().getStatus());
        assertEquals(transactionDTO.getBorrowDate(), result.getFirst().getBorrowDate());
        assertEquals(transactionDTO.getDueDate(), result.getFirst().getDueDate());
        assertEquals(transactionDTO.getReturnDate(), result.getFirst().getReturnDate());
        assertThat(result).hasSize(1).contains(transactionDTO);

        verify(transactionRepository).findAllByMemberId(anyLong());
        verify(transactionMapper).toDTO(List.of(transaction));
    }

    @Test
    void getBookTransactionHistory() {

        Transaction transaction = transactionBuilder.withMember(memberBuilder.build()).build();
        TransactionDTO transactionDTO = transactionDTOBuilder.build();

        when(memberRepository.findById(anyLong())).thenReturn(Optional.of(transaction.getMember()));
        when(transactionRepository.findAllByBookId(anyLong())).thenReturn(List.of(transaction));
        when(transactionMapper.toDTO(List.of(transaction))).thenReturn(List.of(transactionDTO));

        List<TransactionDTO> result = transactionService.getBookTransactionHistory(2L, 1L);

        assertAll(() -> {
            assertEquals(transactionDTO.getId(), result.getFirst().getId());
            assertEquals(transactionDTO.getBookTitle(), result.getFirst().getBookTitle());
            assertEquals(transactionDTO.getMemberName(), result.getFirst().getMemberName());
            assertEquals(transactionDTO.getStatus(), result.getFirst().getStatus());
            assertEquals(transactionDTO.getBorrowDate(), result.getFirst().getBorrowDate());
            assertEquals(transactionDTO.getDueDate(), result.getFirst().getDueDate());
            assertEquals(transactionDTO.getReturnDate(), result.getFirst().getReturnDate());
            assertThat(result).hasSize(1).contains(transactionDTO);
        });

        verify(memberRepository).findById(anyLong());
        verify(transactionRepository).findAllByBookId(anyLong());
        verify(transactionMapper).toDTO(List.of(transaction));
    }
}