package library;

public class Test {
    
    public static void main(String[] args) {
        
        Book book1 = new Book("La force et l'intérêt", "Adon", "545re", true);
        Book book2 = new Book("La mort", "Adon", "465eg", true);
        Book book3 = new Book("Hercule Poireau", "Agatha Christie", "546qq", true);


        Library library = new Library();
        library.addBook(book3);
        library.addBook(book2);
        library.addBook(book1);

        System.out.println("Les livres de Adon sont: ");
        for (Book book : library.findByAuthorName("Adon")) {
            
            System.out.println(book.getTitle() + "\n");
        }
    }
}
