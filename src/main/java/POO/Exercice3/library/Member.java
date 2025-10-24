package library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    
    private String name;
    private List<Book> borrowedBooks = new ArrayList <Book> ();
    
    public Member(String name){
        
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
