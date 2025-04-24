package com.laoBackend.gestionaire_de_biblioteque.testBuilders;

import com.laoBackend.gestionaire_de_biblioteque.domain.Book;
import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Status;
import com.laoBackend.gestionaire_de_biblioteque.domain.Member;
import com.laoBackend.gestionaire_de_biblioteque.domain.Transaction;

import java.time.LocalDateTime;

public class TransactionBuilder {
    MemberBuilder memberBuilder = new MemberBuilder();
    BookBuilder bookBuilder = new BookBuilder();
    private Long id = 1L;
    private Member member = memberBuilder.build();
    private Book book = bookBuilder.build();
    private LocalDateTime borrowDate = LocalDateTime.of(2024,5,25,12,23);
    private LocalDateTime dueDate = borrowDate.plusWeeks(2);
    private LocalDateTime returnDate = null;
    private Status status = Status.BORROWED;

    public TransactionBuilder withId(Long id){
        this.id= id;
        return this;
    }
    public TransactionBuilder withMember(Member member){
        this.member= member;
        return this;
    }
    public TransactionBuilder withBook(Book book){
        this.book= book;
        return this;
    }
    public TransactionBuilder withBorrowDate(LocalDateTime borrowDate){
        this.borrowDate= borrowDate;
        return this;
    }
    public TransactionBuilder withDueDate(LocalDateTime dueDate){
        this.dueDate= dueDate;
        return this;
    }
    public TransactionBuilder withReturnDate(LocalDateTime returnDate){
        this.returnDate= returnDate;
        return this;
    }
    public TransactionBuilder withRole(LocalDateTime returnDate){
        this.returnDate= returnDate;
        return this;
    }
    public TransactionBuilder withStatus(Status status){
        this.status= status;
        return this;
    }

    public Transaction build(){
        return new Transaction(id,member,book,borrowDate,dueDate,returnDate,status);
    }
}
