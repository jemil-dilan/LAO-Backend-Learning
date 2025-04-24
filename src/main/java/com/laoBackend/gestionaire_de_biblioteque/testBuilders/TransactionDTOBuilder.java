package com.laoBackend.gestionaire_de_biblioteque.testBuilders;

import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Status;
import com.laoBackend.gestionaire_de_biblioteque.dto.TransactionDTO;

import java.time.LocalDateTime;

public class TransactionDTOBuilder {
    private Long id = 1L;
    private String memberName = "Pollo";
    private String bookTitle = "The House";
    private LocalDateTime borrowDate = LocalDateTime.of(2024,5,25,12,23);
    private LocalDateTime dueDate = borrowDate.plusWeeks(2);
    private LocalDateTime returnDate = null;
    private Status status = Status.BORROWED;

    public TransactionDTOBuilder withId(Long id){
        this.id= id;
        return this;
    }
    public TransactionDTOBuilder withMemberName(String memberName){
        this.memberName= memberName;
        return this;
    }
    public TransactionDTOBuilder withBookTitle(String bookTitle){
        this.bookTitle= bookTitle;
        return this;
    }
    public TransactionDTOBuilder withBorrowDate(LocalDateTime borrowDate){
        this.borrowDate= borrowDate;
        return this;
    }
    public TransactionDTOBuilder withDueDate(LocalDateTime dueDate){
        this.dueDate= dueDate;
        return this;
    }
    public TransactionDTOBuilder withReturnDate(LocalDateTime returnDate){
        this.returnDate= returnDate;
        return this;
    }
    public TransactionDTOBuilder withStatus(Status status){
        this.status= status;
        return this;
    }

    public TransactionDTO build(){
        return new TransactionDTO(id,memberName,bookTitle,borrowDate,dueDate,returnDate,status);
    }
}
