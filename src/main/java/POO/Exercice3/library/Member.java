package POO.Exercice3.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Member {
    
    private String name;
    private List<Book> memberBorrowedBooks = new ArrayList <Book> ();
    
    public Member(String name){
        
        this.name = name;
    }

    public void putBackBorrowedBook (Library library, String isbn){

        for (Book borrowedBook : memberBorrowedBooks) {

            if (Objects.equals(borrowedBook.getIsbn(), isbn)) {

                memberBorrowedBooks.remove(borrowedBook);
                library.putBackAbook(isbn);
            }
        }
    }

    public void borrowedABook (Library library, String isbn){

        for (Book libraryBook : library.getLibraryBooks()) {

            if (Objects.equals(libraryBook.getIsbn(), isbn)) {

                memberBorrowedBooks.add(libraryBook);
                library.borrowAbook(isbn);
            }
        }
    }

    public List<Book> getMemberBorrowedBooks() {
        return memberBorrowedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
