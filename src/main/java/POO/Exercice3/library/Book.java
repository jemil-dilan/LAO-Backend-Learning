package POO.Exercice3.library;

public class Book {

    private String title;
    private String authorName;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String authorName, String isbn, boolean isAvailable){

        this.title = title;
        this.authorName = authorName;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public String getIsbn(){

        return isbn;
    }

    public String getAuthorName(){

        return authorName;
    }

    public String getTitle(){

        return title;
    }

    public boolean getAvailable(){

        return isAvailable;
    }
    
    public void setAvailable(boolean available){

        this.isAvailable = available;
    }
}