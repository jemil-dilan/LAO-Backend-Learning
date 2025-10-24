package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {

    private List <Book> libraryBooks = new ArrayList <Book> ();

    public void addBook(Book book){

        libraryBooks.add(book);
    }

    public void borrowAbook(String isbn){

        for (Book book : libraryBooks) {
            
            if (Objects.equals(book.getIsbn(), isbn)) {
                
                book.setAvailable(false);
            }
        }
    }

    public void putBackAbook(String isbn){

        for (Book book : libraryBooks) {
            
            if (Objects.equals(book.getIsbn(), isbn)) {
                
                book.setAvailable(true);
            }
        }
    }

    public List<Book> findByAuthorName(String author){
        
        List<Book> listOfAuthorBooks = new ArrayList<Book>();

        for (Book book : libraryBooks) {
            
            if (Objects.equals(book.getAuthorName(), author)) {
                
                listOfAuthorBooks.add(book);
            }
        }

        return listOfAuthorBooks;
    }
}
