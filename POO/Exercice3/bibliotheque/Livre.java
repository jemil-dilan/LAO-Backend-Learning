package bibliotheque;

public class Livre {

    private String titre;
    private String auteur;
    private String isbn;
    private boolean estDisponible;

    public Livre (String titre, String auteur, String isbn, boolean estDisponible){

        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.estDisponible = estDisponible;
    }

    public String getIsbn(){

        return isbn;
    }

    public String getAuteur(){

        return auteur;
    }

    public String getTitre(){

        return titre;
    }

    public boolean getEstDisponible(){

        return estDisponible;
    }
    
    public void setEstDisponible(boolean disponibilite){

        this.estDisponible = disponibilite;
    }
}